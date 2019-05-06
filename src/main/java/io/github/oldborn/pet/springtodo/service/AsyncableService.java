package io.github.oldborn.pet.springtodo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Good God - Korn @Link https://open.spotify.com/track/5JrajjztyjvkuUB8ZqzUML
 * Modified while listening @SpotRepeat {}
 */
public interface AsyncableService<RQ,RS> {
    RS execute(RQ request);
    @Async
    default ListenableFuture<RS> asyncExecute(RQ request){
        return new AsyncResult<>(execute(request));
    }
}
