package dev.kaykyfreitas.databasecsv.step;


import dev.kaykyfreitas.databasecsv.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.function.Function;

@Configuration
@RequiredArgsConstructor
public class PersonStepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step personStep(
            ItemReader<Person> personReader,
            ItemWriter<Person> personWriter
    ) {
        return stepBuilderFactory
                .get("personStep")
                .<Person, Person>chunk(1)
                .reader(personReader)
                .writer(personWriter)
                .build();
    }


}
