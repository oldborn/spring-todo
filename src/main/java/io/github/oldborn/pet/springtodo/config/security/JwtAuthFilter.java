package io.github.oldborn.pet.springtodo.config.security;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Chi - Korn @Link https://open.spotify.com/track/5cLttQXyVI07tUKCN8T4OD
 * Modified while listening @SpotRepeat {}
 */

@Configuration
public class JwtAuthFilter extends AbstractPreAuthenticatedProcessingFilter {


    private JwtAuthUtil jwtAuthUtil;

    public JwtAuthFilter(JwtAuthUtil jwtAuthUtil) {
        this.jwtAuthUtil = jwtAuthUtil;
        this.setAuthenticationManager(new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {

                return new JwtAuthentication(authentication,jwtAuthUtil);
            }
        });
    }

    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        /**String authToken = httpServletRequest.getHeader("Authorization");
        Claims claims = jwtAuthUtil.decode(authToken);
        String userId = claims.getIssuer();
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(null, userId));**/
        System.out.println(httpServletRequest.getRequestURI());
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest httpServletRequest) {
        String principalAndToken = httpServletRequest.getHeader("Authorization");
        return principalAndToken != null ? principalAndToken.split(" ")[0] : null;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest httpServletRequest) {
        String principalAndToken = httpServletRequest.getHeader("Authorization");
        String[] tokens = principalAndToken.split(" ");
        return tokens.length > 1 ? tokens[1] : null;
    }
}
