package io.github.oldborn.pet.springtodo.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Take Me - Korn @Link https://open.spotify.com/track/55elZISkbMgTPP9YViHlqB
 * Modified while listening @SpotRepeat {}
 */
@Component
@ConfigurationProperties("security.auth")
public class JwtAuthUtil {

    @Setter @Getter private String secret;

    public UserClaims decode(String token){

        Claims claims = Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(token).getBody();

        return UserClaims.builder()
                .userId(claims.getIssuer())
                .roles((List<String>) claims.get("role"))
                .build();
    }

    public String encode(UserClaims claims){
        return Jwts.builder().setIssuer(claims.userId).addClaims(Collections.singletonMap("role",claims.roles)).signWith(SignatureAlgorithm.HS256, secret.getBytes()).compact();
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class UserClaims{
        private String userId;
        private List<String> roles;
    }
}
