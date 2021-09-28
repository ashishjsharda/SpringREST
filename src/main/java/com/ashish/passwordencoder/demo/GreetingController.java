package com.ashish.passwordencoder.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GreetingController {
    @Value("${greeting-name:Ashish}")
    private String name;

    @Value("${greeting-coffee:${greeting-name} is drinking coffee}")
    private String coffee;


    @GetMapping
    String getGreeting()
    {
        return name;
    }

}
