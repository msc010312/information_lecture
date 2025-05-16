package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    //	HikariCP DataSource
    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // 또는 oracle.jdbc.driver.OracleDriver
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/bookdb");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }


}
