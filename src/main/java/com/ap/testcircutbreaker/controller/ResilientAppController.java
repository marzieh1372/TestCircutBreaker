package com.ap.testcircutbreaker.controller;


import com.ap.testcircutbreaker.service.ExternalAPICaller;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ResilientAppController {

    private final ExternalAPICaller externalAPICaller;

    public ResilientAppController(ExternalAPICaller externalAPICaller) {
        this.externalAPICaller = externalAPICaller;
    }

    @GetMapping("/circuit-breaker")
    @CircuitBreaker(name = "CircuitBreakerService")
    public String circuitBreakerApi() {
        System.out.println("******* circuitBreakerApi ******");
        return externalAPICaller.callApi();
    }
}
