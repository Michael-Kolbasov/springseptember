package com.epam.spring;


import com.epam.spring.model.Cat;
import com.epam.spring.model.Dog;
import com.epam.spring.repository.CatRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration()
public class ApplicationContextTest {
    private ConfigurableApplicationContext ctx;

    @BeforeEach
    void setUp() {
        ctx = new ClassPathXmlApplicationContext("context.xml");
    }

    @Test
    void checkExistenceOfApplicationContextTest() {
        Dog dog1 = (Dog) ctx.getBean("dog");
        assertEquals(dog1.getName(), "doggo");

        Cat cat1 = (Cat) ctx.getBean("cat");
        assertEquals(cat1.getAge(), 0);

        CatRepositoryImpl catRepository = ctx.getBean("catRepository", CatRepositoryImpl.class);
        assertEquals(catRepository.getName(), "I am a cat repository");
    }
}
