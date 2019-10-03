package com.epam.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Scans for all other configs/components;
 * just to simplify context creation at WebInitializer
 */
@Configuration
@ComponentScan("com.epam.spring")
public class RootConfig {
}
