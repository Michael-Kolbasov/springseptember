package com.epam.spring;

import com.epam.spring.model.AnimalSound;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("testContext.xml");
        AnimalSound animalSound = ctx.getBean("animalSound", AnimalSound.class);
        animalSound.playSound();
        ctx.close();
    }
}
