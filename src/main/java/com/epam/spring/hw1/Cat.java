package com.epam.spring.hw1;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Cat {

    private String name;
    private int age;
}
