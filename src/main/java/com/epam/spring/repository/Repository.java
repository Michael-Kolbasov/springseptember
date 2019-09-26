package com.epam.spring.repository;

import java.util.List;

public interface Repository<T, ID> {
    List<T> findAll();
    T findById(ID id);
    void save(T entity);
    void save(List<T> entities);
}
