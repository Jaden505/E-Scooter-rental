package com.app.esserver;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import java.util.Set;

@Configuration
public class APIconfigurations {

    public Set<String> SECURED_PATHS =
            Set.of("/secured", "/users", "/scooters","/trips");

    @Value("${jwt.token.phrase}")
    private String tokenPhrase;

    @Value("${jwt.token.issuer:my-comp}")
    private String tokenIssuer;

    @Value("${jwt.token-duration:1200}")
    private int tokenDuration;


    public String getTokenPhrase() {
        return tokenPhrase;
    }

    public void setTokenPhrase(String tokenPhrase) {
        this.tokenPhrase = tokenPhrase;
    }

    public String getTokenIssuer() {
        return tokenIssuer;
    }

    public void setTokenIssuer(String tokenIssuer) {
        this.tokenIssuer = tokenIssuer;
    }

    public int getTokenDuration() {
        return tokenDuration;
    }

    public void setTokenDuration(int tokenDuration) {
        this.tokenDuration = tokenDuration;
    }

}
