package com.example.serviceb.controller;

import co.elastic.apm.api.ElasticApm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author diptopol
 * @since 2025-02-10
 */
@Slf4j
@RestController
public class Controller {

    @GetMapping("/message")
    public String getMessage() {
        log.debug("Service B");

        log.debug("Current transaction ID: {}", ElasticApm.currentTransaction().getId());
        log.debug("Current Trace ID: {}", ElasticApm.currentTransaction().getTraceId());

        return "Service B";
    }

}
