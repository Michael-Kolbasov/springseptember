package com.epam.spring.service.springdata;

import com.epam.spring.model.Cat;
import com.epam.spring.repository.springdata.CatRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service("catServiceSpringData")
public class CatServiceImpl implements CatService<Cat, Long> {

    @Setter(onMethod_= {@Autowired, @Qualifier("springDataRepository")})
    private CatRepository catRepository;

    @Override
    @Transactional
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    @Override
    public Cat findById(Long id) {
        return catRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Cat save(Cat entity) {
        return catRepository.save(entity);
    }

    @Override
    @Transactional
    public Collection<Cat> saveAll(Collection<Cat> entities) {
        return catRepository.saveAll(entities);
    }

    @Override
    public Cat findByNameIgnoreCase(String name) {
        return catRepository.findByNameIgnoreCase(name)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Cat> findByAge(int age) {
        return catRepository.findByAge(age);
    }

    @Override
    @Transactional //if not set, will throw TransactionRequiredException: Executing an update/delete query
    public void deleteByNameAndAge(String name, int age) {
        catRepository.deleteByNameAndAge(name, age);
    }
}
