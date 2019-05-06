package io.github.oldborn.pet.springtodo.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
        return UserClaims.builder()
                .userId(Jwts.parser().parseClaimsJwt(token).getBody().getIssuer())
                .build();
    }

    public String encode(UserClaims claims){

        return Jwts.builder().setIssuer(claims.userId).signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.decode(secret)).compact();
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class UserClaims{
        private String userId;
    }
}
