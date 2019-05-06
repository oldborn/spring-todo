package io.github.oldborn.pet.springtodo.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening ${SPOT}
 * Modified while listening @SpotRepeat {}
 */
public class JwtAuthentication implements Authentication {


    private Authentication authentication;

    private JwtAuthUtil jwtAuthUtil;

    public JwtAuthentication(Authentication authentication, JwtAuthUtil jwtAuthUtil) {
        this.authentication = authentication;
        this.jwtAuthUtil = jwtAuthUtil;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authentication.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return jwtAuthUtil.decode((String) authentication.getCredentials()).getUserId();
    }

    @Override
    public Object getDetails() {
        return authentication.getDetails();
    }

    @Override
    public Object getPrincipal() {
        return authentication.getPrincipal();
    }

    @Override
    public boolean isAuthenticated() {
        if (getCredentials() == null) return false;
        return jwtAuthUtil.decode((String) authentication.getCredentials()) != null;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        authentication.setAuthenticated(b);
    }

    @Override
    public String getName() {
        return authentication.getName();
    }
}
