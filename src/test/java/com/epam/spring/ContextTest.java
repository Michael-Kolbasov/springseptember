package com.epam.spring;

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

    @Test
    public void testContextLoads() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("testContext.xml");
        assertNotNull(context);
    }
}
