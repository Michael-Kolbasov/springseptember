package com.epam.spring.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {

    USER,
    ADMIN;

    public static final String SPRING_ROLE_PREFIX = "ROLE_";

    @Override
    public String getAuthority() {
        return SPRING_ROLE_PREFIX + name();
    }

}
