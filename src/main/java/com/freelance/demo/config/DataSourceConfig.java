package com.freelance.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;



public class DataSourceConfig {

    private final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

    @Bean
    public DataSource connectionFactory() {

        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:file:C:/temp/test");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("bhanu.123");
        return dataSourceBuilder.build();


        // return new HikariDataSource(config);
    }
}
