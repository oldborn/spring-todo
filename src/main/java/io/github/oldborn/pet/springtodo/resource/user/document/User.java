package io.github.oldborn.pet.springtodo.resource.user.document;

import com.couchbase.client.java.repository.annotation.Field;
import io.github.oldborn.pet.springtodo.resource.item.document.Item;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Coming Undone - Korn	@Link https://open.spotify.com/track/6p2liQLGoDaLXgND68bfVt
 * Modified while listening @SpotRepeat {Coming Undone - Korn	@Link https://open.spotify.com/track/6p2liQLGoDaLXgND68bfVt}
 */
@Document
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;

    @Field
    private String email;

    @Field
    private String digestedPassword;

    @Reference
    @Singular
    private List<Item> items = new ArrayList<>();
}
