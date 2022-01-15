package com.wallman.greetingmessage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingMessageController {

    private static final String template = "Hello, %s!";

    @GetMapping(path = "/message", produces="application/json")
    public String greeting() {
        String message = "Hello";
        return String.format("{\"message\":\"%s\"}", message);
    }
}
