package io.github.oldborn.pet.springtodo.service.removeItem;

import io.github.oldborn.pet.springtodo.exception.WrongInputException;
import io.github.oldborn.pet.springtodo.resource.item.document.Item;
import io.github.oldborn.pet.springtodo.resource.user.document.User;
import io.github.oldborn.pet.springtodo.resource.user.repository.UserRepository;
import io.github.oldborn.pet.springtodo.service.AsyncableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Safak T. @ 5/7/2019
 * Created while listening Shoots and Ladders - Korn @Link https://open.spotify.com/track/56aPKIfno10w5JCTXrZnoY
 * Modified while listening @SpotRepeat {}
 */
@Service
public class RemoveItemService implements AsyncableService<RemoveItemRQ,RemoveItemRS> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RemoveItemRS execute(RemoveItemRQ request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new WrongInputException("UserId is corrupted"));
        Optional.ofNullable(user.getItems()).orElseGet(ArrayList::new).stream()
                .filter(i -> request.getItemCode().equals(i.getCode()))
                .findAny()
                .ifPresentOrElse(i->user.getItems().remove(i), () -> {throw new WrongInputException("ItemCode is corrupted.");});

        userRepository.save(user);

        return new RemoveItemRS();
    }
}
