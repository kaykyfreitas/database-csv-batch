package dev.kaykyfreitas.databasecsv.job;


import lombok.RequiredArgsConstructor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class PersonJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job personJob(Step personStep) {
        return jobBuilderFactory
                .get("personStep")
                .start(personStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
