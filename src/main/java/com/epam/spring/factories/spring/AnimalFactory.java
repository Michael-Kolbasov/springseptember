package com.epam.spring.factories.spring;

import com.epam.spring.model.Animal;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

@Setter
public class AnimalFactory implements FactoryBean<Animal> {

    private Animal animal;

    @Override
    public Animal getObject() throws Exception {
        return animal;
    }

    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
