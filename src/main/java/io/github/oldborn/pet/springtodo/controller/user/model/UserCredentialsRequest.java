package io.github.oldborn.pet.springtodo.controller.user.model;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Blind - Korn @Link https://open.spotify.com/track/1pr9TZGOXeJUggIal1Wq3R
 * Modified while listening @SpotRepeat {}
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserCredentialsRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
