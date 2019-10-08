package com.epam.spring.controller;

import com.epam.spring.model.User;
import com.epam.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> users() {
        return (List<User>) userRepository.findAll();
    }
}
