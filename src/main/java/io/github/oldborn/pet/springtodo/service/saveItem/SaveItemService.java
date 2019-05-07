package io.github.oldborn.pet.springtodo.service.saveItem;

import io.github.oldborn.pet.springtodo.exception.WrongInputException;
import io.github.oldborn.pet.springtodo.resource.item.document.Item;
import io.github.oldborn.pet.springtodo.resource.item.repository.ItemRepository;
import io.github.oldborn.pet.springtodo.resource.user.document.User;
import io.github.oldborn.pet.springtodo.resource.user.repository.UserRepository;
import io.github.oldborn.pet.springtodo.service.AsyncableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Good God - Korn @Link https://open.spotify.com/track/5JrajjztyjvkuUB8ZqzUML
 * Modified while listening @SpotRepeat {}
 */
@Service
public class SaveItemService implements AsyncableService<SaveItemRQ,SaveItemRS> {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public SaveItemRS execute(SaveItemRQ request) {
        Item toBeSavedItem = null;
        Item savedItem = null;
        if (request.getId() != null){
            toBeSavedItem = itemRepository.findById(request.getId()).orElseThrow(()-> new WrongInputException("Item id is corrupted."));
            toBeSavedItem.setIsDone(request.getIsDone());
            toBeSavedItem.setDescription(request.getDescription());
            toBeSavedItem.setTitle(request.getTitle());
            savedItem = itemRepository.save(toBeSavedItem);
        }else {

            User user = userRepository.findById(request.getUserId()).orElseThrow(()-> new WrongInputException("User id is corrupted"));
            toBeSavedItem = Item.builder()
                    .title(request.getTitle())
                    .description(request.getDescription())
                    .isDone(false)
                    .build();


            if (user.getItems() == null) user.setItems(new ArrayList<>());
            toBeSavedItem.setCode("ITEM#"+user.getItems().size());
            user.getItems().add(toBeSavedItem);
            User savedUser = userRepository.save(user);
        }


        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return SaveItemRS.builder()
                .title(toBeSavedItem.getTitle())
                .description(toBeSavedItem.getDescription())
                .isDone(toBeSavedItem.getIsDone())
                .code(toBeSavedItem.getCode())
                .build();
    }
}
