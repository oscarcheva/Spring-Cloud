package com.microservices.limitsservice.controller;

import com.microservices.limitsservice.configuration.Configuration;
import com.microservices.limitsservice.limitservice.bean.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration config;

    @GetMapping("/limits")
    public Limits retrieveLimit() {

        return new Limits(config.getMin(), config.getMax());
    }
}
