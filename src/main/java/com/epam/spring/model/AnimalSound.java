package com.epam.spring.model;

public class AnimalSound {
    private Animal animal;

    public AnimalSound(Animal animal) {
        this.animal = animal;
    }

    public void playSound() {
        animal.doAnimalStuff();
    }

    private void initXml() {
        System.out.println(getClass() + " in initXml()");
    }

    private void destroyXml() {
        System.out.println(getClass() + " in destroyXml()");
    }
}
