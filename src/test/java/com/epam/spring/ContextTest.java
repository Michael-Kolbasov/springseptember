package com.epam.spring;

import com.epam.spring.model.Cat;
import com.epam.spring.services.CatFightingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * hw1
 * Load test application context
 * <p>
 * hints: module - spring test, test runner classes
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml"})
public class ContextTest {

    @Autowired
    CatFightingService cfs;

    @MockBean(name = "oldCat")
    private Cat oldCat;

    @MockBean(name = "youngCat")
    private Cat youngCat;

    @Before
    public void initTest() {
        Mockito.when(oldCat.getAge()).thenReturn(10);
        Mockito.when(youngCat.getAge()).thenReturn(5);
        Mockito.when(oldCat.getName()).thenReturn("Older");
        Mockito.when(youngCat.getName()).thenReturn("Younger");
    }

    @Test
    public void whoIsOlderTest() {
        Cat cat = cfs.whoIsOlder(oldCat, youngCat);
        Assert.assertEquals("older", cat.getName().toLowerCase());
    }
}
