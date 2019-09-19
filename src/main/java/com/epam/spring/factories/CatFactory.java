package com.epam.spring.factories;

import com.epam.spring.model.Cat;

public class CatFactory implements Factory<Cat> {

    private void onCatFactoryInitFromXml () {

      System.out.println("Cat factory calls" + " onCatFactoryInitFromXml()");
    }

    private void onCatFactoryDestroyFromXml () {

    System.out.println("Cat factory calls" + " onCatFactoryDestroyFromXml()");
  }

    @Override
    public Cat getObject() {
        System.out.println("Produce new cat from factory");
        return new Cat();
    }
}
