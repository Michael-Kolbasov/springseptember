package com.epam.spring.repository;

import com.epam.spring.model.Cat;
import com.epam.spring.util.DatabaseConnection;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Scope
public class CatRepositoryH2Impl implements CatRepository {

    private final static String FIND_ALL = "SELECT * FROM cats";
    private final static String SAVE = "INSERT INTO cats (name, age) VALUES (?, ?)";

    @Setter(onMethod_={@Autowired})
    private DatabaseConnection databaseConnection;

    @Override
    public List<Cat> findAll() {
        Connection connection = databaseConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Cat> cats = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Cat cat = new Cat(id, name, age);
                cats.add(cat);
            }
            return cats;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cat findById(Long aLong) {
        return null;
    }

    @Override
    public void save(Cat entity) {
        Connection connection = databaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getAge());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}