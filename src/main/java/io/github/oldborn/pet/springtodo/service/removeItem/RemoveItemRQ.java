package io.github.oldborn.pet.springtodo.service.removeItem;

import lombok.*;

/**
 * Created by Safak T. @ 5/7/2019
 * Created while listening Shoots and Ladders - Korn @Link https://open.spotify.com/track/56aPKIfno10w5JCTXrZnoY
 * Modified while listening @SpotRepeat {}
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RemoveItemRQ {
    private String userId;
    private String itemCode;
}
