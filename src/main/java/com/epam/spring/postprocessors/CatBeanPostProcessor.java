package com.epam.spring.postprocessors;

import com.epam.spring.annotations.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@Component
public class CatBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("cat")) {

            System.out.println("create cat, call postProcessBeforeInitialization()");
        }

        if(beanName.equals("catFactory")) {

          System.out.println("create catFactory, call postProcessBeforeInitialization()");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("cat")) {

          System.out.println("created cat, call postProcessAfterInitialization()");
        }

        if(beanName.equals("catFactory")) {

          System.out.println("created catFactory, call postProcessAfterInitialization()");
        }
        return bean;
    }
}
