package com.epam.spring.util;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class DatabaseConnection {
    private String url;
    private String username;
    private String password;
}
