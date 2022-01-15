package com.wallman.greetingmessage.controller;

import com.wallman.greetingmessage.repository.GreetingsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingMessageController {

    private final GreetingsRepository repository;

    public GreetingMessageController(GreetingsRepository repository) {
        this.repository = repository;
    }


    @GetMapping(path = "/message", produces="application/json")
    public String greeting() {
        return "Hello";
    }
}
