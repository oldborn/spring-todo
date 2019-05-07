package io.github.oldborn.pet.springtodo.service.addUser;

import lombok.*;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Blind - Korn @Link https://open.spotify.com/track/1pr9TZGOXeJUggIal1Wq3R
 * Modified while listening @SpotRepeat {}
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AddUserRQ {
    private String email;
    private String password;
}
