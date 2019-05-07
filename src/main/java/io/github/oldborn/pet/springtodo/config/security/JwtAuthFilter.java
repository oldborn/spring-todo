package io.github.oldborn.pet.springtodo.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
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
        if (principalAndToken == null) return null;
        String[] tokens = principalAndToken.split(" ");
        return tokens.length > 1 ? tokens[1] : null;
    }
}
