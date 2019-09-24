package com.epam.spring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Owl implements Animal {

    @Override
    public void doAnimalStuff() {
        System.out.println("Owuuu");
    }

}
