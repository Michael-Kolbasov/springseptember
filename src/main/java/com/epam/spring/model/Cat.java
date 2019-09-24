package com.epam.spring.model;

import com.epam.spring.annotations.InjectRandomInt;
import lombok.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat implements Animal, InitializingBean, DisposableBean {
    @EqualsAndHashCode.Exclude
    @InjectRandomInt(min = 100, max=200)
    private Long id;
    private int age;
    private String name;

    @PostConstruct
    private void postConstruct() {
        System.out.println("in PostConstruct()");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("In PreDestroy()");
    }

    private void initXml() {
        System.out.println(getClass() + " in initXml()");
    }

    private void destroyXml() {
        System.out.println(getClass() + " in destroyXml()");
    }

    public static Cat generateCat() {
        System.out.println("in Cat.generateCat()");
        return new Cat();
    }

    @Override
    public void doAnimalStuff() {
        System.out.println("meow");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("in DisplosableBean destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("in InitializingBean afterPropertiesSet()");
    }
}
