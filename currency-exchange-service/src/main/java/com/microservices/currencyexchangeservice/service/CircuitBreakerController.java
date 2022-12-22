package com.microservices.currencyexchangeservice.service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample")
    //@Retry(name = "sample", fallbackMethod = "hardCodedResponse")
    //@CircuitBreaker(name = "sample", fallbackMethod = "hardCodedResponse")
    //@RateLimiter(name = "sample")
    @Bulkhead(name="sample") // Concurrent calls.
    public String sampleAPI() {

        return "All good";
    }

    public String hardCodedResponse(Exception ex)
    {
        return "There was a problem";
    }
}
