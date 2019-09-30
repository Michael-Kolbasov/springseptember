package com.epam.spring.repository;

import com.epam.spring.constants.SqlConstants;
import com.epam.spring.model.Cat;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Qualifier("jdbcTemplateRepository")
public class CatRepositoryJdbcTemplateImpl implements CatRepository {

    @Setter(onMethod_= {@Autowired})
    private JdbcTemplate jdbcTemplate;

    @Setter(onMethod_= {@Autowired})
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Cat> findAll() {
        return jdbcTemplate.query(SqlConstants.FIND_ALL_CATS, BeanPropertyRowMapper.newInstance(Cat.class));

        //return jdbcTemplate.query(SqlConstants.FIND_ALL_CATS, new CatRowMapper());
    }

    @Override
    public Cat findById(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        return namedParameterJdbcTemplate.queryForObject(SqlConstants.FIND_CAT_BY_ID_NAMED, params, new CatRowMapper());

        // return jdbcTemplate.queryForObject(SqlConstants.FIND_CAT_BY_ID, new Object[]{id}, new CatRowMapper());

        /*return jdbcTemplate.query(
                SqlConstants.FIND_CAT_BY_ID,
                preparedStatementSetter -> preparedStatementSetter.setLong(1, id),
                resultSet -> {
                    resultSet.next();
                    long catId = resultSet.getLong("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    return new Cat(catId, name, age);
                });*/
    }

    @Override
    public void save(Cat entity) {
        Map<String, Object> params = new HashMap<String, Object>() {{
            put("name", entity.getName());
            put("age", entity.getAge());
        }};
        namedParameterJdbcTemplate.update(SqlConstants.SAVE_CAT, params);
    }

    @Override
    public void save(List<Cat> entities) {
        entities.forEach(this::save);
    }


    private static final class CatRowMapper implements RowMapper<Cat> {
        @Override
        public Cat mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Cat(rs.getLong("id"), rs.getString("name"), rs.getInt("age"));
        }
    }
}
