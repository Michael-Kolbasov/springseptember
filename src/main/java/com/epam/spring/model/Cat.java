package com.epam.spring.model;

import com.epam.spring.annotations.InjectRandomInt;
import lombok.*;
import org.springframework.beans.factory.DisposableBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat implements Animal, DisposableBean {
    @EqualsAndHashCode.Exclude
    @InjectRandomInt(min = 100, max=200)
    private Long id;
    private int age;
    private String name;

    @PostConstruct
    private void postConstruct() {
        System.out.println("cat call postConstruct");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println("cat call preDestroy");
    }

    private void onCatInitFromXml() {

        System.out.println("Cat calls" + " onCatInitFromXml()");
    }

    private void onCatDestroyFromXml() {

      System.out.println("Cat calls" + " onCatDestroyFromXml()");
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
}
