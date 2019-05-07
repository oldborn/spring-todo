package io.github.oldborn.pet.springtodo.service.listItem;

import io.github.oldborn.pet.springtodo.service.listItem.model.Mode;
import lombok.*;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Let The Guilt Go - Korn @Link https://open.spotify.com/track/3lAxX47BnSDTTtlCcxSiEw
 * Modified while listening @SpotRepeat {}
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ListItemRQ {

    private String userId;

    @Builder.Default
    private Mode mode = Mode.ALL;
}
