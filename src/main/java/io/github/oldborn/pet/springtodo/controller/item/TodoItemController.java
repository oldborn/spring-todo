package io.github.oldborn.pet.springtodo.controller.item;

import io.github.oldborn.pet.springtodo.controller.item.model.TodoAddItemRQ;
import io.github.oldborn.pet.springtodo.controller.item.model.TodoItem;
import io.github.oldborn.pet.springtodo.controller.item.model.UpdateTodoItemRQ;
import io.github.oldborn.pet.springtodo.service.listItem.ListItemService;
import io.github.oldborn.pet.springtodo.service.listItem.ListItemRQ;
import io.github.oldborn.pet.springtodo.service.listItem.ListItemRS;
import io.github.oldborn.pet.springtodo.service.listItem.model.Mode;
import io.github.oldborn.pet.springtodo.service.markItem.MarkItemRQ;
import io.github.oldborn.pet.springtodo.service.markItem.MarkItemService;
import io.github.oldborn.pet.springtodo.service.removeItem.RemoveItemRQ;
import io.github.oldborn.pet.springtodo.service.removeItem.RemoveItemService;
import io.github.oldborn.pet.springtodo.service.saveItem.SaveItemRQ;
import io.github.oldborn.pet.springtodo.service.saveItem.SaveItemRS;
import io.github.oldborn.pet.springtodo.service.saveItem.SaveItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private MarkItemService markItemService;

    @Autowired
    private RemoveItemService removeItemService;

    @PostMapping
    public SaveItemRS addItem(@RequestBody TodoAddItemRQ todoItem){
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        SaveItemRS saveItemRS = saveItemService.execute(SaveItemRQ.builder()
                .title(todoItem.getTitle())
                .description(todoItem.getDescription())
                .userId(userId)
                .build());

        return saveItemRS;
    }

    @GetMapping
    public List<TodoItem> getItems(){
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        ListItemRS listItemRS = listItemService.execute(ListItemRQ.builder()
                .mode(Mode.ALL)
                .userId(userId)
                .build());

        return listItemRS.getItems().stream().map(
                ti -> TodoItem.builder()
                        .code(ti.getCode())
                        .isDone(ti.getIsDone())
                        .title(ti.getTitle())
                        .description(ti.getDescription())
                        .build()
        ).collect(Collectors.toList());
    }

    @PutMapping("/{item-code}/mark")
    public void mark(@PathVariable("item-code") String itemCode){
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        markItemService.execute(MarkItemRQ.builder().userId(userId).itemCode(itemCode).build());
    }

    @PutMapping("/{item-code}")
    public void update(@PathVariable("item-code") String itemCode, @RequestBody UpdateTodoItemRQ updateTodoItemRQ){
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        saveItemService.execute(SaveItemRQ.builder()
                .userId(userId)
                .code(itemCode)
                .isDone(updateTodoItemRQ.getIsDone())
                .description(updateTodoItemRQ.getDescription())
                .title(updateTodoItemRQ.getTitle())
                .build());
    }

    @DeleteMapping("/{item-code}")
    public void remove(@PathVariable("item-code") String itemCode){
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
        removeItemService.execute(RemoveItemRQ.builder().userId(userId).itemCode(itemCode).build());
    }

}
