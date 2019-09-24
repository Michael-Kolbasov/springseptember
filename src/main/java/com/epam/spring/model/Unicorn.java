package com.epam.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unicorn implements Animal {

    @EqualsAndHashCode.Exclude
    private Long id;
    private int age;
    private String name;

    @Override
    public String doAnimalStuff() {
       return "Rainbow";
    }
}
