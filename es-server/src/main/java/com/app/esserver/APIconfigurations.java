package com.app.esserver;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import java.util.Set;

@Configuration
public class APIconfigurations {

    public Set<String> SECURED_PATHS =
            Set.of("/secured", "/users", "/scooters","/trips");

    @Value("${jwt.token.phrase}")
    private String phrase;

    @Value("${jwt.token.issuer:esserver}")
    private String issuer;

    @Value("${jwt.token.duration:1200}")
    private int duration;


    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
