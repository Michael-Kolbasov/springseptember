package com.epam.spring;

import com.epam.spring.model.Animal;
import com.epam.spring.model.Unicorn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean(name = "unicorn")
    public Animal creaeUnicorn(){
        return new Unicorn();
    }
}
