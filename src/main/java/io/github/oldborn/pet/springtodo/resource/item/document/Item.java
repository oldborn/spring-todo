package io.github.oldborn.pet.springtodo.resource.item.document;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.*;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import javax.validation.constraints.NotNull;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening All In the Family - Korn @Link https://open.spotify.com/track/7yYvvOB7CuzdVldb6zOk1m
 * Modified while listening @SpotRepeat {}
 */
@Document
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Item {

    @Id
    @GeneratedValue(strategy = UNIQUE)
    private String id;

    @Field
    @NotNull
    private String title;

    @Field
    private String description;

    @Field
    private Boolean isDone = Boolean.FALSE;

    @CreatedDate
    private DateTime created;

    @LastModifiedDate
    private DateTime updated;


}
