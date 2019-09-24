package com.epam.spring;

import com.epam.spring.model.Cat;
import com.epam.spring.service.CatService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        CatService catServiceImpl = ctx.getBean("catServiceImpl", CatService.class);
        Cat cat = catServiceImpl.findById(2L);
        System.out.println(cat);
        ctx.close();
    }

}
