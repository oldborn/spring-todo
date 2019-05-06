package io.github.oldborn.pet.springtodo.service.authUser;

import io.github.oldborn.pet.springtodo.config.security.JwtAuthUtil;
import io.github.oldborn.pet.springtodo.exception.WrongInputException;
import io.github.oldborn.pet.springtodo.resource.user.document.User;
import io.github.oldborn.pet.springtodo.resource.user.repository.UserRepository;
import io.github.oldborn.pet.springtodo.service.AsyncableService;
import io.github.oldborn.pet.springtodo.util.Sha256Digest;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening A.D.I.D.A.S. - Korn @Link https://open.spotify.com/track/0xgsyoVvRFSYvV5cdtYhX1
 * Modified while listening @SpotRepeat {}
 */
@Service
public class AuthUserService implements AsyncableService<AuthUserRQ, AuthUserRS> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtAuthUtil jwtAuthUtil;

    @Override
    public AuthUserRS execute(AuthUserRQ request) {
        String digestedPassword = Sha256Digest.digest(request.getPassword());
        User user = userRepository.findByEmailAndDigestedPassword(request.getEmail(),digestedPassword);
        if (user == null) throw new WrongInputException("User not found.");

        String token = jwtAuthUtil.encode(JwtAuthUtil.UserClaims.builder()
                .userId(user.getId())
                .build());

        return AuthUserRS.builder()
                .token(token)
                .build();
    }
}
