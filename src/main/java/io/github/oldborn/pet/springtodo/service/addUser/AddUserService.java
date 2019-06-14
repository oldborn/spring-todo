package io.github.oldborn.pet.springtodo.service.addUser;

import io.github.oldborn.pet.springtodo.exception.InternalServerException;
import io.github.oldborn.pet.springtodo.exception.WrongInputException;
import io.github.oldborn.pet.springtodo.resource.user.repository.UserRepository;
import io.github.oldborn.pet.springtodo.service.AsyncableService;
import io.github.oldborn.pet.springtodo.util.Sha256Digest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.oldborn.pet.springtodo.resource.user.document.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Blind - Korn @Link https://open.spotify.com/track/1pr9TZGOXeJUggIal1Wq3R
 * Modified while listening @SpotRepeat {}
 */
@Service
public class AddUserService implements AsyncableService<AddUserRQ, AddUserRS> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AddUserRS execute(AddUserRQ request) {
        String digestedPassword = Sha256Digest.digest(request.getPassword());
        if (userRepository.findByEmail(request.getEmail()) != null)
            throw new WrongInputException("User exists.");

        userRepository.save(User.builder()
                .email(request.getEmail())
                .digestedPassword(digestedPassword)
                .roles(request.getRoles())
                .build());
        return new AddUserRS();
    }
}
