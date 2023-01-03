package com.app.esserver.exceptions;

public class JWTAcceptableExption extends Exception {
    public JWTAcceptableExption(String No_Acces_Message) {
        super(No_Acces_Message);
    }
}

