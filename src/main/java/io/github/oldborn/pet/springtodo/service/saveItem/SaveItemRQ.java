package io.github.oldborn.pet.springtodo.service.saveItem;

import lombok.*;

/**
 * Created by Safak T. @ 5/7/2019
 * Created while listening New Fang - Them Crooked Vultures @Link https://open.spotify.com/track/7uJLdyIAaYLGT0oLw7I6b3
 * Modified while listening @SpotRepeat {}
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SaveItemRQ {
    private String userId;
    private String id;
    private String title;
    private String description;
    @Builder.Default private Boolean isDone = Boolean.FALSE;
}

