package com.epam.spring.model;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

public interface Animal {
    String doAnimalStuff();
}
