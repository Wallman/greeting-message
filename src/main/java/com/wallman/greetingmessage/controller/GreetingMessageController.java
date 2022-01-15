package com.wallman.greetingmessage.controller;

import com.wallman.greetingmessage.domain.Greeting;
import com.wallman.greetingmessage.repository.GreetingsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GreetingMessageController {

    private final GreetingsRepository repository;

    public GreetingMessageController(GreetingsRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/message", produces = "application/json")
    public Mono<Greeting> message() {
        String message = "Hello";
        return Mono.just(new Greeting(message));
    }
}
