package io.github.oldborn.pet.springtodo.service.markItem;

import io.github.oldborn.pet.springtodo.exception.WrongInputException;
import io.github.oldborn.pet.springtodo.resource.item.document.Item;
import io.github.oldborn.pet.springtodo.resource.user.document.User;
import io.github.oldborn.pet.springtodo.resource.user.repository.UserRepository;
import io.github.oldborn.pet.springtodo.service.AsyncableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Safak T. @ 5/7/2019
 * Created while listening Get Up! (feat. Skrillex) - Korn @Link https://open.spotify.com/track/25EgA1A1OZBRw25Mjyw08g
 * Modified while listening @SpotRepeat {}
 */
@Service
public class MarkItemService implements AsyncableService<MarkItemRQ,MarkItemRS> {

    @Autowired
    private UserRepository userRepository;


    @Override
    public MarkItemRS execute(MarkItemRQ request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new WrongInputException("UserId is corrupted."));
        Item itemToBeMarked = user.getItems().stream().filter(i -> request.getItemCode().equals(i.getCode())).findAny().orElseThrow(()-> new WrongInputException("ItemCode is corrupted"));
        itemToBeMarked.flipDone();
        userRepository.save(user);
        return new MarkItemRS();
    }
}
