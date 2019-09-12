package com.epam.spring.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat implements Animal {
    @EqualsAndHashCode.Exclude
    private Long id;
    private int age;
    private String name;

    private void init() {
        System.out.println(getClass() + " in init()");
    }

    private void destroy() {
        System.out.println(getClass() + " in destroy()");
    }

    public static Cat generateCat() {
        System.out.println("in Cat.generateCat()");
        return new Cat((long) (Math.random() * 10000), 25, "default name");
    }

    @Override
    public void doAnimalStuff() {
        System.out.println("meow");
    }
}
