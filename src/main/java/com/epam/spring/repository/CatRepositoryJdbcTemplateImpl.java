package com.epam.spring.repository;

import com.epam.spring.constants.SqlConstants;
import com.epam.spring.model.Cat;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("jdbcTemplateRepository")
public class CatRepositoryJdbcTemplateImpl implements CatRepository {

    @Setter(onMethod_= {@Autowired})
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Cat> findAll() {
        return null;
    }

    @Override
    public Cat findById(Long id) {
        return jdbcTemplate.query(
                SqlConstants.FIND_CAT_BY_ID,
                preparedStatementSetter -> preparedStatementSetter.setLong(1, id),
                resultSet -> {
                    resultSet.next();
                    long catId = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    return new Cat(catId, name, age);
                });
    }

    @Override
    public void save(Cat entity) {

    }

}
