package com.wallman.greetingmessage.controller;

import com.wallman.greetingmessage.domain.Greeting;
import com.wallman.greetingmessage.repository.GreetingsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Random;

@RestController
public class GreetingMessageController {

    private final GreetingsRepository repository;

    public GreetingMessageController(GreetingsRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/message", produces="application/json")
    public Mono<Greeting> message() {
        List<String> greetings = repository.getAll();
        int randomIndex = greetings.size() == 1 ? 1 : greetings.size() - 1;
        String message = greetings.get(new Random().nextInt(randomIndex));
        return Mono.just(new Greeting(message));
    }
}
