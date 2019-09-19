package com.epam.spring.repository;

import com.epam.spring.model.Cat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatRepositoryImpl implements CatRepository {

    private Map<String, Cat> cats;

    @Override
    public Cat findAll() {
        return null;
    }

    @Override
    public Cat findById(Long aLong) {
        return null;
    }

}
