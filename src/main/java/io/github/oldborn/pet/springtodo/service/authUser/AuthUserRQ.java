package io.github.oldborn.pet.springtodo.service.authUser;

import lombok.*;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Right Now - Korn @Link https://open.spotify.com/track/5Rx4nxhTGDPRvZoqVtrwyQ
 * Modified while listening @SpotRepeat {}
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AuthUserRQ {
    private String email;
    private String password;
}
