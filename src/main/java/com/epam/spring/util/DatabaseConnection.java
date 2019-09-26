package com.epam.spring.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@PropertySource("classpath:/hibernate.properties")
public class DatabaseConnection {

    @Value("${hibernate.connection.url}")
    private String url;

    @Value("${hibernate.connection.username}")
    private String username;

    @Value("${hibernate.connection.password}")
    private String password;

    @Getter
    private Connection connection;

    @PostConstruct
    private void openConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PreDestroy
    private void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
