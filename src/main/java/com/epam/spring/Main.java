package com.epam.spring;

import com.epam.spring.model.Cat;
import com.epam.spring.repository.CatRepositoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        Cat cat = (Cat) ctx.getBean("cat");
        CatRepositoryImpl catRepository = ctx.getBean("catRepository", CatRepositoryImpl.class);
        System.out.println(catRepository);
    }
}
