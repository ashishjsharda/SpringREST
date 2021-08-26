package com.ashish.passwordencoder.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

class Coffee{
    private final String id;
    private String name;

    public String getId() {
        return id;
    }

    public  Coffee(String name)
    {
        this(UUID.randomUUID().toString(),name);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Coffee(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
