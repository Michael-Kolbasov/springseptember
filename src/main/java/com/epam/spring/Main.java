package com.epam.spring;

import com.epam.spring.model.Cat;
import com.epam.spring.service.springdata.CatService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
        CatService<Cat, Long> catServiceImpl = (CatService) ctx.getBean("catServiceSpringData");

        System.out.println("All:");
        System.out.println(catServiceImpl.findAll());
        System.out.println();

        System.out.println("FindByNameIgnoreCase - kotik2: ");
        System.out.println(catServiceImpl.findByNameIgnoreCase("kotik2"));
        System.out.println();

        System.out.println("Saving new cat with age = 2...");
        catServiceImpl.save(new Cat("cat for save", 2));

        System.out.println("All:");
        System.out.println(catServiceImpl.findAll());
        System.out.println();

        System.out.println("Find by age = 2: ");
        System.out.println(catServiceImpl.findByAge(2));
        System.out.println();

        System.out.println("Deleting cats with name = kotik1 and age = 2...");
        catServiceImpl.deleteByNameAndAge("kotik1", 2);
        System.out.println();

        System.out.println("All:");
        System.out.println(catServiceImpl.findAll());

        ctx.close();
    }
}
