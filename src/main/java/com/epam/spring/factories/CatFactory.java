package com.epam.spring.factories;

import com.epam.spring.model.Cat;

public class CatFactory implements Factory<Cat> {

    @Override
    public Cat getObject() {
        System.out.println("in catFactory");
        //return new Cat((long) 111, 111, "cat from factory");
        return new Cat();
    }
}
