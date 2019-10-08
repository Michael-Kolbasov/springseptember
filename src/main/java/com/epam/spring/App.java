package com.epam.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
                       // you may use @Import instead of @ComponentScan to define config classes explicitly
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
