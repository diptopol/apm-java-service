package com.example.servicea.controller;

import co.elastic.apm.api.ElasticApm;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

/**
 * @author diptopol
 * @since 2025-02-10
 */
@Slf4j
@RestController
@AllArgsConstructor
public class Controller {

    private final WebClient.Builder webClientBuilder;

    @GetMapping("/message")
    public String getMessage(@RequestHeader Map<String, String> headers) {
        log.debug("Service A");

        log.debug("Current transaction ID: {}", ElasticApm.currentTransaction().getId());

        log.debug("Current Trace ID: {}", ElasticApm.currentTransaction().getTraceId());

        WebClient webClient = webClientBuilder.baseUrl("http://service-b").build();

        String response = webClient.get().uri("/message").retrieve().bodyToMono(String.class).block();

        log.debug("Response From Service B: {}", response);

        return "Service A";
    }

}
