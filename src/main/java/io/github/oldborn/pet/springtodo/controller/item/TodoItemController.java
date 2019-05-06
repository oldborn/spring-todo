package io.github.oldborn.pet.springtodo.controller.item;

import io.github.oldborn.pet.springtodo.controller.item.model.TodoAddItemRQ;
import io.github.oldborn.pet.springtodo.controller.item.model.TodoItem;
import io.github.oldborn.pet.springtodo.resource.item.document.Item;
import io.github.oldborn.pet.springtodo.service.listItem.ListItemService;
import io.github.oldborn.pet.springtodo.service.listItem.model.ListItemRQ;
import io.github.oldborn.pet.springtodo.service.listItem.model.ListItemRS;
import io.github.oldborn.pet.springtodo.service.listItem.model.Mode;
import io.github.oldborn.pet.springtodo.service.saveItem.SaveItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Pretty - Korn @Link https://open.spotify.com/track/27qsQGjOEBiVoZJB1ViI4Y
 * Modified while listening @SpotRepeat {}
 */
@RestController
@RequestMapping("/item")
public class TodoItemController {

    @Autowired
    private SaveItemService saveItemService;

    @Autowired
    private ListItemService listItemService;

    @PostMapping
    public TodoItem addItem(@RequestBody TodoAddItemRQ todoItem){
        Item item = saveItemService.execute(Item.builder()
                .isDone(false)
                .description(todoItem.getDescription())
                .title(todoItem.getTitle())
                .build());

        return TodoItem.builder()
                .creationDate(item.getCreated())
                .description(item.getDescription())
                .id(item.getId())
                .title(item.getTitle())
                .isDone(item.getIsDone())
                .build();
    }

    @GetMapping
    public List<TodoItem> getItems(){
        ListItemRS listItemRS = listItemService.execute(ListItemRQ.builder().mode(Mode.ALL).build());
        return listItemRS.getItems().stream().map(
                ti -> TodoItem.builder()
                        .isDone(ti.getIsDone())
                        .title(ti.getTitle())
                        .description(ti.getDescription())
                        .id(ti.getId())
                        .build()
        ).collect(Collectors.toList());
    }

}
