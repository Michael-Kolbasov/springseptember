package com.epam.spring;

import com.epam.spring.model.Cat;
import com.epam.spring.service.CatService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        CatService catServiceImpl = ctx.getBean("catServiceImpl", CatService.class);
        catServiceImpl.save(new Cat("young cat", 1));
        System.out.println(catServiceImpl.findAll());
        System.out.println(catServiceImpl.findById(2L));


        try {
            catServiceImpl.save(Arrays.asList(
                    new Cat("barsik", 5),
                    new Cat("murzik", 3),
                    new Cat("ryska", 1),
                    new Cat("yuki", 3),
                    new Cat("cat2", 3),
                    new Cat("cat3", 3)
            ));
        } catch (RuntimeException e) {
            // ignore - transactional
        }

        System.out.println(catServiceImpl.findAll());
        ctx.close();
    }

}
