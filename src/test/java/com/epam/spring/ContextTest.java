package com.epam.spring;

import com.epam.spring.model.TestDinosaur;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * hw1
 * Load test application context
 *
 * hints: module - spring test, test runner classes
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testContext.xml"})
public class ContextTest {
    
    ClassPathXmlApplicationContext context;
    
    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("testContext.xml");
    }

    @Test
    public void testContextLoads() {
        assertNotNull(context);
    }
    
    @Test
    public void testFactoryWithContext() {
        TestDinosaur dino = context.getBean("dinosaur", TestDinosaur.class);
        assertNotNull(dino);
        dino.doRawr();
    }
}
