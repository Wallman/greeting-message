package com.wallman.greetingmessage.controller;

import com.wallman.greetingmessage.repository.GreetingsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class GreetingMessageController {

    private final GreetingsRepository repository;

    public GreetingMessageController(GreetingsRepository repository) {
        this.repository = repository;
    }


    @GetMapping(path = "/message", produces="application/json")
    public String greeting() {
        List<String> greetings = repository.getAll();
        String message = greetings.get(new Random().nextInt(greetings.size() - 1));
        return String.format("{\"message\":\"%s\"}", message);
    }
}
