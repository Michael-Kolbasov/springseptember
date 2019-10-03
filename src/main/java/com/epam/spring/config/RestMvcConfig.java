package com.epam.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * Helps with Model < - > JSON converting and many more (but not used here)
 */
@Configuration
@EnableSpringDataWebSupport
public class RestMvcConfig implements RepositoryRestConfigurer {

}
