package com.ashish.passwordencoder.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class RestApiDemoController {
    private List<Coffee> coffeeList=new ArrayList<>();
    public RestApiDemoController(){
        coffeeList.addAll(List.of(
                new Coffee("Nescafe"),
                new Coffee("Bru Cafe"),
                new Coffee("Suzu's Cafe")
        ));
    }

    @GetMapping("/coffees")
    Iterable<Coffee>getCoffes(){
        return coffeeList;
    }

}
