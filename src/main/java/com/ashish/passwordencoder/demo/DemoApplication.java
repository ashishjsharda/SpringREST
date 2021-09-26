package com.ashish.passwordencoder.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

@Entity
class Coffee{

    @Id
    private String id;
    private String name;

    public Coffee() {

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
