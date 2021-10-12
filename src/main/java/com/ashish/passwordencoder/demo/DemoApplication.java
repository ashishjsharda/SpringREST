package com.ashish.passwordencoder.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix = "droid")
    Droid createDroid()
    {
        return new Droid();
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


