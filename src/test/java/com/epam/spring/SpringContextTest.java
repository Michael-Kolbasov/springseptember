package com.epam.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/context.xml"})
public class SpringContextTest {

  @Test
  public void test() {
    System.out.println("\nContext up\n");
  }

}
