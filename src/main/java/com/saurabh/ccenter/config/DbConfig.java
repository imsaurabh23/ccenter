package com.saurabh.ccenter.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
    @Bean
    public DataSource dataSource(@Value("${spring.datasource.driver}") String driver,
                                 @Value("${spring.datasource.url}") String url) {
        return DataSourceBuilder.create().driverClassName(driver).url(url).build();
    }
}

