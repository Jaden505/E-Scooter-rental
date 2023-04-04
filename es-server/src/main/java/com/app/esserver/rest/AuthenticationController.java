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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.app.esserver.models.Scooter;
import com.app.esserver.models.Trip;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(allowCredentials = "true", origins = {"http://localhost:8080", "http://localhost:8085"})
public class AuthenticationController {

    @Autowired
    private APIconfigurations apiConfig;

    @PostMapping("/authentication/login")
    public ResponseEntity<User> login(@RequestBody ObjectNode form){

        String email = form.get("email").textValue();
        String password =  form.get("password").textValue();

        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)){
            throw new JwtException("Missing email or password");
        }
        String name  = email.replaceAll("@hva.nl", "");
        if (!name.equals(password)){
            throw new JwtException("Invalid email or password");
        }

        User user = new User();
        user.setEmail(email);
        user.setName(name);

        JWToken jwToken = new JWToken(name, 1000l, "gebruiker");
        String token = jwToken.encode(apiConfig.getIssuer(), apiConfig.getPhrase(),
                apiConfig.getDuration());

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);

        // Set the Access-Control-Expose-Headers header
        headers.set("Access-Control-Expose-Headers", "Authorization");


        return ResponseEntity.accepted()
                .headers(headers)
                .body(user);
    }
}

