package com.app.esserver.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JWToken {

    private static final String CALLNAME_CLAIM = "sub";
    private static final String ROLE_CLAIM = "role";
    private static final String USERID_CLAIM = "id";
    public static final String ATTRIBUTE_NAME = "toke_attribute";

    private String callName = null;
    private Long userId = null;
    private String role = null;

    public JWToken(String callName, Long userId, String role) {
        this.callName = callName;
        this.userId = userId;
        this.role = role;
    }

    public static JWToken decode(String token, String phrase) {
        Key key = getKey(phrase);
        Jws<Claims> jws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
        Claims claims = jws.getBody();
        JWToken jwToken = new JWToken(claims.get(CALLNAME_CLAIM).toString(),Long.valueOf(claims.get(USERID_CLAIM).toString()),
                claims.get(ROLE_CLAIM).toString() );
        return jwToken;
    }

    public String encode(String issuer, String passphrase, int expiration) {
        Key key = getKey(passphrase);

        return Jwts.builder()
                .claim(ROLE_CLAIM, this.role)
                .claim(CALLNAME_CLAIM, this.callName)
                .claim(USERID_CLAIM, this.userId)
                .setIssuer(issuer)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000L))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    private static Key getKey(String passphrase) {
        byte[] hmacKey = passphrase.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(hmacKey, SignatureAlgorithm.HS512.getJcaName());
    }

}
