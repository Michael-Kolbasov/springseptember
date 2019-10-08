package com.epam.starter;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

public class ProductionAppListener {

    @EventListener(ContextRefreshedEvent.class)
    public void listen() {
        System.out.println("Wow, this is prod?");
    }

}
