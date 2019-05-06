package io.github.oldborn.pet.springtodo.service.saveItem;

import io.github.oldborn.pet.springtodo.resource.item.document.Item;
import io.github.oldborn.pet.springtodo.resource.item.repository.ItemRepository;
import io.github.oldborn.pet.springtodo.service.AsyncableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Good God - Korn @Link https://open.spotify.com/track/5JrajjztyjvkuUB8ZqzUML
 * Modified while listening @SpotRepeat {}
 */
@Service
public class SaveItemService implements AsyncableService<Item,Item> {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item execute(Item request) {
        return itemRepository.save(request);
    }
}
