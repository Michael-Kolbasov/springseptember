package com.epam.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat implements Animal {

    @EqualsAndHashCode.Exclude
    private Long id;
    private int age;
    private String name;

    @Override
    public void doAnimalStuff() {
        System.out.println("meow");
    }

}
