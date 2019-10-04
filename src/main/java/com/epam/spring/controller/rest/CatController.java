package com.epam.spring.controller.rest;

import com.epam.spring.annotation.Loggable;
import com.epam.spring.model.Cat;
import com.epam.spring.service.springdata.CatService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Jackson library transforms models to JSON
 */
@SuppressWarnings("unchecked")
@Loggable
@RestController
@RequestMapping("/cats")
public class CatController {

    @Setter(onMethod_= {@Autowired, @Qualifier("catServiceSpringData")})
    private CatService catService;

    @GetMapping
    @Loggable
    public List<Cat> allCats() {
        return catService.findAll();
    }

    @GetMapping("/{id}")
    public Cat catById(@PathVariable("id") Long id) {
        return (Cat) catService.findById(id);
    }

    @GetMapping("/save")
    public ModelAndView save(ModelAndView modelAndView) {
        modelAndView.setViewName("cat/catsave");
        return modelAndView;
    }

    @PostMapping(value = "/save", consumes = "application/json")
    public String save(@RequestBody Cat cat) {
        catService.save(cat);
        return "saved cat: " + cat;
    }

    @GetMapping("/exception")
    public void throwException() throws RuntimeException {
        throw new RuntimeException();
    }
}
