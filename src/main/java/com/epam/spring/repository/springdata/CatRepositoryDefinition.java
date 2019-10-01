package com.epam.spring.repository.springdata;

import com.epam.spring.model.Cat;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.Optional;

@RepositoryDefinition(domainClass = Cat.class, idClass = Long.class)
public interface CatRepositoryDefinition {
    Optional<Cat> findByNameIgnoreCase(String name);
}
