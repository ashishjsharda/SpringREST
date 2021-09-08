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
@RequestMapping("/coffees")
public class RestApiDemoController {
    private List<Coffee> coffeeList=new ArrayList<>();
    public RestApiDemoController(){
        coffeeList.addAll(List.of(
                new Coffee("Nescafe"),
                new Coffee("Bru Cafe"),
                new Coffee("Suzu's Cafe")
        ));
    }

    @GetMapping
    Iterable<Coffee>getCoffes(){
        return coffeeList;
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeById(@PathVariable String id)
    {
        for (Coffee coffee:coffeeList){
            if (coffee.getId().equals(id)){
                return Optional.of(coffee);
            }
        }
        return Optional.empty();
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee)
    {
        coffeeList.add(coffee);
        return coffee;

    }
    @PutMapping("/{id}")
    Coffee putCoffee(@PathVariable String id,@RequestBody Coffee coffee)
    {
        int coffeeIndex=-1;
        for (Coffee coffee1:coffeeList)
        {
            if (coffee1.getId().equals(id))
            {
                coffeeIndex=coffeeList.indexOf(coffee1);
                coffeeList.set(coffeeIndex,coffee);
            }
        }
        return coffeeIndex==-1?postCoffee(coffee):coffee;
    }

    @DeleteMapping("/{id}")
    public void deletCoffee(@PathVariable String id)
    {
        coffeeList.removeIf(c->c.getId().equals(id));
    }
}
