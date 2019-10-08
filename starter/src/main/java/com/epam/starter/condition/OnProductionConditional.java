package com.epam.starter.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class OnProductionConditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String env = context.getEnvironment().getProperty("spring.epam.env");
        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        return "production".equals(env) || Arrays.asList(activeProfiles).contains("production");
    }

}
