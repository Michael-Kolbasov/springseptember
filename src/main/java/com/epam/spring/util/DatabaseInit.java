package com.epam.spring.util;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
@DependsOn("databaseConnection")
public class DatabaseInit {

    @Setter(onMethod_ = {@Autowired})
    private DatabaseConnection db;

    @PostConstruct
    private void buildDatabase() {
        Connection connection = db.getConnection();

        ClassPathResource schema = new ClassPathResource("schema.sql");
        ClassPathResource populate = new ClassPathResource("populate.sql");

        try (Statement statement = connection.createStatement()) {
            String[] schemaSql = String.join("", Files.readAllLines(schema.getFile().toPath())).split(";");
            String[] populateSql = String.join("", Files.readAllLines(populate.getFile().toPath())).split(";");
            for (String sql : schemaSql) {
                System.out.println(sql);
                statement.execute(sql);
            }
            for (String sql : populateSql) {
                System.out.println(sql);
                statement.execute(sql);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
