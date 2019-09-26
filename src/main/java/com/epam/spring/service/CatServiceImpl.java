package com.epam.spring.service;

import com.epam.spring.model.Cat;
import com.epam.spring.repository.CatRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Setter(onMethod_={@Autowired, @Qualifier("hibernateRepository")})
    private CatRepository catRepository;

    @Override
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    @Override
    public Cat findById(Long id) {
        return catRepository.findById(id);
    }

    @Override
    public void save(Cat entity) {
        catRepository.save(entity);
    }

    @Override
    @Transactional
    public void save(List<Cat> list) {
        catRepository.save(list);
    }
}
