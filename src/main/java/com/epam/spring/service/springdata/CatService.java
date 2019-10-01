package com.epam.spring.service.springdata;

import java.util.Collection;
import java.util.List;

public interface CatService<T, ID> {
    List<T> findAll();
    T findById(ID id);
    T save(T entity);
    Collection<T> saveAll(Collection<T> entities);
    T findByNameIgnoreCase(String name);
    List<T> findByAge(int age);
    void deleteByNameAndAge(String name, int age);
}
