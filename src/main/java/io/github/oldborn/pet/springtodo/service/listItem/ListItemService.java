package io.github.oldborn.pet.springtodo.service.listItem;

import io.github.oldborn.pet.springtodo.exception.WrongInputException;
import io.github.oldborn.pet.springtodo.resource.item.document.Item;
import io.github.oldborn.pet.springtodo.resource.item.repository.ItemRepository;
import io.github.oldborn.pet.springtodo.resource.user.document.User;
import io.github.oldborn.pet.springtodo.resource.user.repository.UserRepository;
import io.github.oldborn.pet.springtodo.service.AsyncableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Let The Guilt Go - Korn	@Link https://open.spotify.com/track/3lAxX47BnSDTTtlCcxSiEw
 * Modified while listening @SpotRepeat {Let The Guilt Go - Korn	@Link https://open.spotify.com/track/3lAxX47BnSDTTtlCcxSiEw}
 */
@Service
public class ListItemService implements AsyncableService<ListItemRQ, ListItemRS> {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ListItemRS execute(ListItemRQ request) {
        User owner = userRepository.findById(request.getUserId()).orElseThrow(() -> new WrongInputException("UserId is corrupted."));
        List<Item> items = owner.getItems();
        return ListItemRS.builder()
                .items(items)
                .build();
    }
}
