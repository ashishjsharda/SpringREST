package com.ashish.passwordencoder.demo;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controller Class
 * @author ashish
 */
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

    @GetMapping("/coffees/{id}")
    Optional<Coffee> getCoffeById(@PathVariable String id)
    {
        for (Coffee coffee:coffeeList){
            if (coffee.getId().equals(id)){
                return Optional.of(coffee);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee)
    {
        coffeeList.add(coffee);
        return coffee;

    }
}
