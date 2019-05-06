package io.github.oldborn.pet.springtodo.controller.user;

import io.github.oldborn.pet.springtodo.controller.user.model.LoginResponse;
import io.github.oldborn.pet.springtodo.controller.user.model.SignupResponse;
import io.github.oldborn.pet.springtodo.controller.user.model.UserCredentialsRequest;
import io.github.oldborn.pet.springtodo.service.addUser.AddUserRQ;
import io.github.oldborn.pet.springtodo.service.addUser.AddUserService;
import io.github.oldborn.pet.springtodo.service.authUser.AuthUserRQ;
import io.github.oldborn.pet.springtodo.service.authUser.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Blind - Korn @Link https://open.spotify.com/track/1pr9TZGOXeJUggIal1Wq3R
 * Modified while listening @SpotRepeat {}
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AddUserService addUserService;

    @Autowired
    private AuthUserService authUserService;

    @PostMapping("/sign-up")
    public SignupResponse createUser(@RequestBody @Validated UserCredentialsRequest request){
        addUserService.execute(AddUserRQ.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build());
        return new SignupResponse();
    }

    @PostMapping("/sign-in")
    public LoginResponse login(@RequestBody @Validated UserCredentialsRequest request){
        return LoginResponse.builder()
                .token(authUserService.execute(
                        AuthUserRQ.builder()
                                .email(request.getEmail())
                                .password(request.getPassword())
                                .build()
                ).getToken())
                .build();
    }

}
