package io.github.oldborn.pet.springtodo.resource.user.repository;

import io.github.oldborn.pet.springtodo.resource.user.document.User;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Got the Life - Korn @Link https://open.spotify.com/track/2IdHMVUxMbLHW5HU4OvOcZ
 * Modified while listening @SpotRepeat {}
 */
@Repository
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "item")
public interface UserRepository extends CrudRepository<User,String> {

    User findByEmail(String email);

    User findByEmailAndDigestedPassword(String email, String digestedPassword);

}
