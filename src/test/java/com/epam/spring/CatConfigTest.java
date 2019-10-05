package com.epam.spring;

import com.epam.spring.hw1.CatConfig;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CatConfigTest {

    @Test
    public void TestCat(){
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(CatConfig.class);
        Assert.assertNotNull(context);
        Assert.assertNotNull(context.getBean("cat"));

    }
}
