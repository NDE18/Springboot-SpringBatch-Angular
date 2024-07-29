package com.nde.app.synchro.appSynchronisation.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MysqlDataSourceConfiguration {

    @ConfigurationProperties("spring.datasource.mysql")
    @Bean
    public DataSourceProperties mySqlDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource mySqlDataSource(){

        return mySqlDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
