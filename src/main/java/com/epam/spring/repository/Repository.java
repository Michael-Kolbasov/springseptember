package com.epam.spring.repository;

public interface Repository<T, ID> {
    T findAll();
    T findById(ID id);
}
