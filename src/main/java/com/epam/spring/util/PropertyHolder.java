package com.epam.spring.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PropertyHolder {

    @Value("${own.hardcoded.property}")
    private Integer hardcodedProperty;

    @Value("#{systemEnvironment['somepropertyname'] ?: 'system property not set'}")
    private String systemProperty;

    @Value("${own.random.property}")
    private Integer random;

}
