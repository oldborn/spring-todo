package io.github.oldborn.pet.springtodo.service.listItem;

import io.github.oldborn.pet.springtodo.resource.item.document.Item;
import lombok.*;

import java.util.List;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Let The Guilt Go - Korn @Link https://open.spotify.com/track/3lAxX47BnSDTTtlCcxSiEw
 * Modified while listening @SpotRepeat {}
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ListItemRS {
    @Singular private List<Item> items;
}
