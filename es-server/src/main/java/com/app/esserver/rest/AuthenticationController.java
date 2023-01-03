package com.app.esserver.rest;

import com.app.esserver.APIconfigurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {

    private APIconfigurations apiConfig;
    @PostMapping("/authentication/login")
    public ResponseEntity<String> login(){
        return ResponseEntity.ok("Hello");
    }







}
