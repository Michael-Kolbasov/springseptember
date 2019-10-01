package com.epam.spring.repository.springdata;

import org.springframework.stereotype.Repository;

@Repository("springDataRepository")
public interface CatRepository extends CatRepositoryDefinition, CatRepositorySpringData {
}
