package com.app.esserver.rest;

import com.app.esserver.APIconfigurations;
import com.app.esserver.models.User;
import com.app.esserver.utils.JWToken;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {

    private APIconfigurations apiConfig;
    @PostMapping("/authentication/login")
    public ResponseEntity<User> login(@RequestBody ObjectNode form){
        String email = form.get("email").textValue();
        String password =  form.get("password").textValue();
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)){
            throw new JwtException("Wrong credentials");
        }
        String name  = email.replaceAll("@hva.nl", "");
        if (!name.equals(password)){
            throw new JwtException("Wrong credentials");
        }

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        JWToken jwToken = new JWToken(name, 1000l, "gebruiker");
        String token = jwToken.encode(apiConfig.getTokenIssuer(), apiConfig.getTokenPhrase(),
                apiConfig.getTokenDuration());
        return ResponseEntity.accepted()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .body(user);

    }







}
