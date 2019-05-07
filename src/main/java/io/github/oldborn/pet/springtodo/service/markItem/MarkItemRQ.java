package io.github.oldborn.pet.springtodo.service.markItem;

import lombok.*;

/**
 * Created by Safak T. @ 5/7/2019
 * Created while listening Get Up! (feat. Skrillex) - Korn @Link https://open.spotify.com/track/25EgA1A1OZBRw25Mjyw08g
 * Modified while listening @SpotRepeat {}
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class MarkItemRQ {
    private String userId;
    private String itemCode;
}
