package com.nde.app.synchro.appSynchronisation.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class H2DataSourceConfiguration {

    @ConfigurationProperties("spring.datasource.sqlite")
    @Bean
    public DataSourceProperties sqliteDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource sqliteDataSource(){

        return sqliteDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
