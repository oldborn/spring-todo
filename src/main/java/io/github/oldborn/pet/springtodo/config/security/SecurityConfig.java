package io.github.oldborn.pet.springtodo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Evolution - Korn @Link https://open.spotify.com/track/3iLCPsQR9oBdJU05N1H1EA
 * Modified while listening @SpotRepeat {}
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/health").permitAll()
                .antMatchers("/swagger-resources/**","/swagger-ui.html","/swagger-ui.html/**","/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**").permitAll()
                .antMatchers("/user","/user/**").permitAll()
                .and()
                    .addFilter(jwtAuthFilter)
                    .authorizeRequests()
                .anyRequest().authenticated();

       // http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


    }
}
