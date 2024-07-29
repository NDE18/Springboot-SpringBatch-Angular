package com.nde.app.synchro.appSynchronisation.config;

import com.nde.app.synchro.appSynchronisation.dto.UserDto;
import com.nde.app.synchro.appSynchronisation.processor.UserProcessor;
import com.nde.app.synchro.appSynchronisation.repositories.h2repositories.H2UserRepository;
import com.nde.app.synchro.appSynchronisation.repositories.mysqlrepositories.MysqlUserRepository;
import com.nde.app.synchro.appSynchronisation.reader.H2UserReader;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class H2BatchConfig {

    @Autowired
    private H2UserRepository h2UserRepository;

    @Autowired
    private MysqlUserRepository mysqlUserRepository;

    @Autowired
    UserProcessor userProcessor;

    /*@Autowired
    H2UserReader h2userReader;

    @Autowired
    UserWriter userWriter;*/

    // READER
    @Bean
    public ItemReader<UserDto> reader(@Qualifier("sqliteEntityManagerFactoryBean") EntityManagerFactory entityManagerFactory){
        JpaPagingItemReader<UserDto> reader
                = new JpaPagingItemReader<>();
        reader.setEntityManagerFactory(
                entityManagerFactory);
        reader.setQueryString(
                "SELECT b FROM _user u"); // Use the entity name
        // 'Book'
        reader.setPageSize(10);
        return reader;
    }

    // STEP
    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager
                     transactionManager, @Qualifier("reader")ItemReader<UserDto> reader,
                     @Qualifier("UserWriter")ItemWriter<UserDto> writer) {
        return new StepBuilder("step", jobRepository)
                .<UserDto, UserDto>chunk(10, transactionManager)
                .reader(reader)
                .processor(userProcessor)
                .writer(writer)
                .taskExecutor(taskExecutor())
                .build();
    }

    // JOB
    @Bean
    public Job job(JobRepository jobRepository, Step step) {
        return new JobBuilder("job", jobRepository)
                .flow(step)
                .end()
                .build();
    }

    // TASKEXECUTOR
    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(10);
        return taskExecutor;
    }

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
                dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:appsynchrodb");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
