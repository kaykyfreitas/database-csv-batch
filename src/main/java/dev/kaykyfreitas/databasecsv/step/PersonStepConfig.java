package dev.kaykyfreitas.databasecsv.step;


import dev.kaykyfreitas.databasecsv.dto.PersonBankDataDto;
import dev.kaykyfreitas.databasecsv.entity.InputFile;

import lombok.RequiredArgsConstructor;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PersonStepConfig {

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step personStep(
            ItemReader<InputFile> personReader,
            ItemProcessor<InputFile, PersonBankDataDto> personBankDataProcessor,
            ItemWriter<PersonBankDataDto> personWriter
    ) {
        return stepBuilderFactory
                .get("personStep")
                .<InputFile, PersonBankDataDto>chunk(1)
                .reader(personReader)
                .processor(personBankDataProcessor)
                .writer(personWriter)
                .build();
    }

}
