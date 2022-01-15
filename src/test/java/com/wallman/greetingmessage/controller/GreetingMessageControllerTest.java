package com.wallman.greetingmessage.controller;

import com.wallman.greetingmessage.repository.GreetingsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = GreetingMessageController.class)
@Import(GreetingsRepository.class)
public class GreetingMessageControllerTest {

    @MockBean
    GreetingsRepository repository;

    @Autowired
    private WebTestClient webClient;

    @Test
    void testGetEmployeeById() {
        when(repository.getAll()).thenReturn(List.of("Hello"));

        webClient.get().uri("/message")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.message").isEqualTo("Hello");
    }

}