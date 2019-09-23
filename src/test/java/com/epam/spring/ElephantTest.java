package com.epam.spring;

import com.epam.spring.model.Elephant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * ElephantTest checks if the elephant bean was loaded from ApplicationContext and his name matches context-set name.
 * We need to specify the location of context in order to get rid of context mistakes.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ElephantTest-context.xml"})
public class ElephantTest {

    @Autowired
    private Elephant elephant;

    @Test
    public void testElephant() {
        assertEquals("Dambo", elephant.getName());
    }
}