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
    private String name;
    private Map<String, Cat> cats;

    public CatRepositoryImpl(Map<String, Cat> cats) {
        this.cats = cats;
    }

    @Override
    public Cat findAll() {
        return null;
    }

    @Override
    public Cat findById(Long aLong) {
        return null;
    }

    public void destroyCatRepository() {
        System.out.println("cat repository call" + " destroyCatRepository()");
    }

    public void initCatRepository() {
        System.out.println("cat repository call" + " initCatRepository()");
    }
}
