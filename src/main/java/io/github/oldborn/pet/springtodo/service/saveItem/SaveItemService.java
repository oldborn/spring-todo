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
import java.util.Optional;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Good God - Korn @Link https://open.spotify.com/track/5JrajjztyjvkuUB8ZqzUML
 * Modified while listening @SpotRepeat {}
 */
@Service
public class SaveItemService implements AsyncableService<SaveItemRQ,SaveItemRS> {


    @Autowired
    private UserRepository userRepository;

    @Override
    public SaveItemRS execute(SaveItemRQ request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(()-> new WrongInputException("User id is corrupted"));

        Optional.ofNullable(user.getItems()).orElseGet(ArrayList::new).stream()
                .filter(i -> request.getCode() != null && request.getCode().equals(i.getCode()))
                .findAny()
                .ifPresentOrElse(i->{
                    if (request.getTitle() != null) i.setTitle(request.getTitle());
                    if (request.getDescription() != null) i.setDescription(request.getDescription());
                    if (request.getIsDone() != null) i.setIsDone(request.getIsDone());
                },()->{
                    if (user.getItems() == null) user.setItems(new ArrayList<>());
                    user.getItems().add(Item.builder()
                            .title(request.getTitle())
                            .description(request.getDescription())
                            .isDone(false)
                            .code("ITEM#"+System.currentTimeMillis())
                            .build());
                });

        userRepository.save(user);

        return new SaveItemRS();
    }
}
