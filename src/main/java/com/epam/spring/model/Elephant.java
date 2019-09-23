package com.epam.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Elephant implements Animal {
    private String name;

    @Override
    public void doAnimalStuff() {
        System.out.println("Waahhh");
    }

    private void initXml() {
        System.out.println(getClass() + " in initXml()");
    }

    private void destroyXml() {
        System.out.println(getClass() + " in destroyXml()");
    }
}
