package com.epam.spring.service.jdbcandjdbctemplateandhibernate;

import java.util.List;

public interface Service<T, ID> {
    List<T> findAll();
    T findById(ID id);
    void save(T entity);
    void save(List<T> list);
}
