package com.handson.cicd.service;
import org.springframework.stereotype.Service;
@Service
public class GreetingService {
    public String greeting(){
        return "So you finally made a pipeline eh?";
    }
}
