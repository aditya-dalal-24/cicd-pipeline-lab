package com.handson.cicd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.handson.cicd.service.GreetingService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping("/api/greeting")

    public String greeting(){
        return greetingService.greeting();
    }
}
