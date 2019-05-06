package io.github.oldborn.pet.springtodo.controller.item.model;

import lombok.*;
import org.joda.time.DateTime;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Hold On - Korn @Link https://open.spotify.com/track/4hD3UA6t7sN7y5EI9GB7zP
 * Modified while listening @SpotRepeat {}
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TodoItem {
    private String id;
    private String title;
    private String description;
    private DateTime creationDate;
    private Boolean isDone;
}
