package com.epam.spring.services;

import com.epam.spring.model.Animal;
import com.epam.spring.model.Cat;

public class CatFightingService {

    public Cat whoIsOlder(Cat firstCat, Cat secondCat) {
        if (firstCat.getAge()>secondCat.getAge()) {
            return firstCat;
        } else {
            return secondCat;
        }
    }
}
