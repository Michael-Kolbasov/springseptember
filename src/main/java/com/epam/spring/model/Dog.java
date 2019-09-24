package com.epam.spring.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dog extends AbstractAnimal implements Animal {

    @EqualsAndHashCode.Exclude
    private Long id;
    private int age;

    @Override
    public String doAnimalStuff() {
        return  "woof";
    }
}
