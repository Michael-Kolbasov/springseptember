package com.epam.spring.repository;

import com.epam.spring.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

    @Query("select new Cat(id, name, age) from Cat c where c.age = :age")
    List<Cat> findByAge(@Param("age") int age);

    @Modifying //if not set, will throw JdbcSQLNonTransientException
    @Query(value = "delete from cats c where c.name = :name and c.age = :age",
            nativeQuery = true)
    void deleteByNameAndAge(@Param("name") String name, @Param("age") int age);

    Optional<Cat> findByNameIgnoreCase(String name);
}
