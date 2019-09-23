package com.epam.spring;

import com.epam.spring.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * hw1
 * Load test application context
 *
 * hints: module - spring test, test runner classes
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class ContextTest {

  @Autowired
  private ApplicationContext ctx;

  @Test
  public void testContextLoads() {
    assertNotNull("There is no bean with testConfig name", ctx.getBean(TestConfig.class));
  }
}
