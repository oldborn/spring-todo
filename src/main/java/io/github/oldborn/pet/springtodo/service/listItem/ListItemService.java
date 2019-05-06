package io.github.oldborn.pet.springtodo.service.listItem;

import io.github.oldborn.pet.springtodo.resource.item.document.Item;
import io.github.oldborn.pet.springtodo.resource.item.repository.ItemRepository;
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

    @Override
    public ListItemRS execute(ListItemRQ request) {
        List<Item> items = new LinkedList<>();
        itemRepository.findAll().forEach(items::add);
        return ListItemRS.builder()
                .items(items)
                .build();
    }
}
