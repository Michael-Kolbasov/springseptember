package com.epam.spring.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    @EqualsAndHashCode.Exclude
    private Long id;
    private int age;
    private String name;

    private void init() {
        System.out.println(getClass() + " in init()");
    }

    private void destroy() {
        System.out.println(getClass() + " in destroy()");
    }
}
