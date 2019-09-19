package com.epam.spring;

import com.epam.spring.model.TestDinosaur;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * hw1
 * Load test application context
 *
 * hints: module - spring test, test runner classes
 */
public class ContextTest {

    TestDinosaur dino;
    ClassPathXmlApplicationContext context;
    
    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("testContext.xml");
        dino = (TestDinosaur) context.getBean("dinosaur");
    }

    @Test
    public void testContextLoads() {
        assertNotNull(context);
        assertNotNull(dino);
        dino.doRawr();
    }
}
