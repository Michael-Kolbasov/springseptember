package com.epam.starter;

import com.epam.starter.condition.ConditionalOnProduction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StarterConfig {

    @Bean
    public AppListener appListener() {
        return new AppListener();
    }

    @Bean
    @ConditionalOnProduction
    public ProductionAppListener productionAppListener() {
        return new ProductionAppListener();
    }

}
