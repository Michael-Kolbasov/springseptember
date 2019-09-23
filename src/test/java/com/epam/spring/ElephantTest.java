package com.epam.spring;

import com.epam.spring.model.Elephant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

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