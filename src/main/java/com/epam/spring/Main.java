package com.epam.spring;

import com.epam.spring.model.Cat;
import com.epam.spring.repository.CatRepository;
import com.epam.spring.service.CatService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        CatService catServiceImpl = ctx.getBean("catServiceImpl", CatService.class);
        List<Cat> all = catServiceImpl.findAll();
        System.out.println(all);
        Cat cat = createCat();
        catServiceImpl.save(cat);
        List<Cat> again = catServiceImpl.findAll();
        System.out.println(again);
        ctx.close();
    }

    private static Cat createCat() {
        return new Cat("new cat", 0);
    }
}
