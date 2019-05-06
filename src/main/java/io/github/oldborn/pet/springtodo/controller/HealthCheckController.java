package io.github.oldborn.pet.springtodo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Safak T. @ 5/6/2019
 * Created while listening Alone I Break - Korn @Link https://open.spotify.com/track/2sofatcLrRA6B6tju4a31K
 * Modified while listening @SpotRepeat {}
 */
@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping
    public String health(@RequestParam(value = "msg",required = false) String msg){
        return msg == null ? "OK" : msg;
    }

}
