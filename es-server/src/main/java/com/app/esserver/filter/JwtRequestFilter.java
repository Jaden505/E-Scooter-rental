package com.app.esserver.filter;

import com.app.esserver.APIconfigurations;
import com.app.esserver.utils.JWToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private APIconfigurations apiConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if(HttpMethod.OPTIONS.matches(request.getMethod()) || this.apiConfig.SECURED_PATHS.stream().noneMatch(request.getServletPath()::startsWith)) {
            filterChain.doFilter(request, response);
            return;
        }

        String encryptedtoken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (encryptedtoken == null){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no token!!");
            return;
        }
        JWToken jwToken = JWToken.decode(encryptedtoken.replace("Bearer ", ""), apiConfig.getTokenPhrase());

        if (jwToken == null){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no  valid token!!");
        }
        request.setAttribute(JWToken.ATTRIBUTE_NAME, jwToken);
        filterChain.doFilter(request, response);

    }

}
