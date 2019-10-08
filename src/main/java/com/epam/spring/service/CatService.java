package com.epam.spring.service;

import com.epam.spring.model.Cat;

import java.util.Collection;
import java.util.List;

public interface CatService {
    List<Cat> findAll();
    Cat findById(Long id);
    Cat save(Cat entity);
    Collection<Cat> saveAll(Collection<Cat> entities);
    Cat findByNameIgnoreCase(String name);
    List<Cat> findByAge(int age);
    void deleteByNameAndAge(String name, int age);
}
