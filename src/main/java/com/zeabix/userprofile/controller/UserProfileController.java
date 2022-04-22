package com.zeabix.userprofile.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/v1")
public class UserProfileController {

    @GetMapping("health")
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> healthCheck(){
        return Mono.just("OK");
    }

}
