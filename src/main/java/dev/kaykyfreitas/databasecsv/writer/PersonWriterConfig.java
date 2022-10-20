package dev.kaykyfreitas.databasecsv.writer;


import dev.kaykyfreitas.databasecsv.dto.PersonBankDataDto;

import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.Writer;

@Configuration
public class PersonWriterConfig {

    @Bean
    public FlatFileItemWriter<PersonBankDataDto> personWriter() {
        return new FlatFileItemWriterBuilder<PersonBankDataDto>()
                .name("personWriter")
                .resource(new FileSystemResource("files/invoice.txt"))
                .delimited()
                .delimiter(";")
                .names("personId", "name", "email", "birth", "age", "bankId", "agency", "account", "bank")
                .headerCallback(headerCallback())
                .build();
    }

    private FlatFileHeaderCallback headerCallback() {
        return new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                writer.append("person_id;name;email;birth;age;bank_id;agency;account;bank");
            }
        };
    }

}
