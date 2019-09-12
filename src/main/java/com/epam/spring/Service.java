package com.epam.spring;

@org.springframework.stereotype.Service("iamservice")
public class Service {
    public Service() {
        System.out.println("i am service and in constructor");
    }
}
