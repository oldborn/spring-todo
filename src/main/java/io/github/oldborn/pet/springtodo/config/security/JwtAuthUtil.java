package io.github.oldborn.pet.springtodo.config.security;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Take Me - Korn @Link https://open.spotify.com/track/55elZISkbMgTPP9YViHlqB
 * Modified while listening @SpotRepeat {}
 */
@Component
public class JwtAuthUtil {

    public Claims decode(String token){
        return null;
    }

    public String encode(Claims claims){
        return null;
    }
}
