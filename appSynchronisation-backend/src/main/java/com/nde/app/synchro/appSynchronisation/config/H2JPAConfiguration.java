package com.nde.app.synchro.appSynchronisation.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.nde.app.synchro.appSynchronisation.repositories.h2repositories",
        entityManagerFactoryRef = "sqliteEntityManagerFactoryBean",
        transactionManagerRef = "sqliteTransactionManager"
)
public class H2JPAConfiguration {

    @Bean
    LocalContainerEntityManagerFactoryBean sqliteEntityManagerFactoryBean(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier("sqliteDataSource") DataSource dataSource){

        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.nde.app.synchro.appSynchronisation.entities.h2entities")
                .build();
    }

    @Bean
    PlatformTransactionManager sqliteTransactionManager(@Qualifier("sqliteEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb){

        return new JpaTransactionManager(emfb.getObject());
    }
}
