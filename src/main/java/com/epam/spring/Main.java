package com.epam.spring;

import com.epam.spring.model.Cat;
import com.epam.spring.model.Dog;
import com.epam.spring.repository.CatRepositoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        Cat cat = (Cat) ctx.getBean("cat");
        Dog dog = (Dog) ctx.getBean("dog");
        CatRepositoryImpl catRepository = ctx.getBean("catRepository", CatRepositoryImpl.class);
        ctx.close();
    }
}
