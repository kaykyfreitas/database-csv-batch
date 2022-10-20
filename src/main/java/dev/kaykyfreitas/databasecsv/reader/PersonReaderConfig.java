package dev.kaykyfreitas.databasecsv.reader;


import dev.kaykyfreitas.databasecsv.entity.InputFile;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PersonReaderConfig {

    @Bean
    public FlatFileItemReader<InputFile> bankDataFileReader() {
        return new FlatFileItemReaderBuilder<InputFile>()
                .name("bankDataFileReader")
                .resource(new FileSystemResource("inputfiles/input_file.csv"))
                .delimited()
                .names("id", "username", "phone", "email")
                .addComment("--")
                .targetType(InputFile.class)
                .build();
    }

}
