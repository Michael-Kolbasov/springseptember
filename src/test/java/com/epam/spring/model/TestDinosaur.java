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
public class TestDinosaur {
    
    @EqualsAndHashCode.Exclude
    private int id;
    private int age;
    private String name;
    
    public void doRawr() {
        System.out.println("Rawr!");
    }

    private void initXml() {
        System.out.println(getClass() + " in initXml()");
    }

    private void destroyXml() {
        System.out.println(getClass() + " in destroyXml()");
    }
}
