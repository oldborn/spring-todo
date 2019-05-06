package io.github.oldborn.pet.springtodo.resource.item.repository;

import io.github.oldborn.pet.springtodo.resource.item.document.Item;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Good God - Korn @Link https://open.spotify.com/track/5JrajjztyjvkuUB8ZqzUML
 * Modified while listening @SpotRepeat {}
 */
@Repository
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "item")
public interface ItemRepository extends CrudRepository<Item, String> {
}
