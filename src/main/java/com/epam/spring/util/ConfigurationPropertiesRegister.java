package com.epam.spring.util;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RootProperties.class)
public class ConfigurationPropertiesRegister {
}
