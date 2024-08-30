package com.environments.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppBaseConfig {
    @Value("${db.database.name}")
    private String database;
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/".concat(database));
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setPassword("12345");
        dataSource.setUsername("root");
        return dataSource;
    }
}
