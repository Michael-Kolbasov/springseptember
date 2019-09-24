package com.epam.spring.config;

import com.epam.spring.model.Cat;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Setter(onMethod_= {@Autowired})
    private Environment environment;

    @Bean
    public Cat cat() {
        return new Cat();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getRequiredProperty("db.url"));
        driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
        driverManagerDataSource.setUsername(environment.getRequiredProperty("db.username"));
        driverManagerDataSource.setPassword(environment.getRequiredProperty("db.password"));
        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public DataSourceInitializer dataSourceInitializer() {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource());
        initializer.setDatabasePopulator(populator());
        initializer.setDatabaseCleaner(cleaner());
        return initializer;
    }

    private DatabasePopulator populator() {
        ClassPathResource schema = new ClassPathResource("schema.sql");
        ClassPathResource populate = new ClassPathResource("populate.sql");
        return new ResourceDatabasePopulator(schema, populate);

        /*return connection -> {
            Statement statement = connection.createStatement();
            statement.execute(SqlConstants.CREATE_TABLE_CATS);
            statement.execute(SqlConstants.POPULATE_TABLE_CATS);
        };*/
    }

    private DatabasePopulator cleaner() {
        return new ResourceDatabasePopulator(new ClassPathResource("drop.sql"));

        /*return connection -> {
            Statement statement = connection.createStatement();
            statement.execute(SqlConstants.DROP_TABLE_CATS);
        };*/
    }

    //one of possibilities of embedded db init
    /*@Bean
    public EmbeddedDatabase embeddedDatabase() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("classpath:schema.sql")
                .addScript("classpath:populate.sql")
                .build();
    }*/

}
