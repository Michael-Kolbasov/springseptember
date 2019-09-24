package com.epam.spring;

import com.epam.spring.model.Unicorn;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * hw1
 * Load test application context
 *
 * hints: module - spring test, test runner classes
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Unicorn.class })
public class ContextTest {

    @Autowired
    private Unicorn unicorn;

    @Test
    public void testContextLoads() {
        assertEquals ("Rainbow", unicorn.doAnimalStuff());
    }
}
