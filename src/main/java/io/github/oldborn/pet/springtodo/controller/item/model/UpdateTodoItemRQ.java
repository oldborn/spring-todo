package io.github.oldborn.pet.springtodo.controller.item.model;

import lombok.*;

/**
 * Created by Safak T. @ 5/7/2019
 * Created while listening It's On! - Korn	@Link https://open.spotify.com/track/0e06Zwd1027jFtmrRbXAjl
 * Modified while listening @SpotRepeat {It's On! - Korn	@Link https://open.spotify.com/track/0e06Zwd1027jFtmrRbXAjl}
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UpdateTodoItemRQ {
    private String title;
    private String description;
    private Boolean isDone;
}
