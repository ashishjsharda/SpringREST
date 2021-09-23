package com.ashish.passwordencoder.demo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final CoffeeRepository coffeeRepository;
    public RestApiDemoController(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;

    }

    @GetMapping
    Iterable<Coffee>getCoffes(){
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Coffee> getCoffeById(@PathVariable String id)
    {
        return coffeeRepository.findById(id);
    }

    @PostMapping
    Coffee postCoffee(@RequestBody Coffee coffee)
    {
        return coffeeRepository.save(coffee);


    }
    @PutMapping("/{id}")
    ResponseEntity putCoffee(@PathVariable String id,@RequestBody Coffee coffee)
    {

        return (!coffeeRepository.existsById(id))
                ? new ResponseEntity<>(coffeeRepository.save(coffee),
                HttpStatus.CREATED)
                : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletCoffee(@PathVariable String id)
    {

        coffeeRepository.deleteById(id);
    }
}
