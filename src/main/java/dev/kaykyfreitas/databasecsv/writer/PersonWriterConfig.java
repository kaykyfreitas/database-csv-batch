package dev.kaykyfreitas.databasecsv.writer;

import dev.kaykyfreitas.databasecsv.entity.Person;
import org.springframework.batch.item.file.FlatFileHeaderCallback;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.ResourceSuffixCreator;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.Writer;

@Configuration
public class PersonWriterConfig {

    @Bean
    public FlatFileItemWriter<Person> personWriter() {
        return new FlatFileItemWriterBuilder<Person>()
                .name("personWriter")
                .resource(new FileSystemResource("files/invoice.txt"))
                .delimited()
                .delimiter(";")
                .names("name", "email", "birth", "age", "id")
                .headerCallback(headerCallback())
                .build();
    }

    private FlatFileHeaderCallback headerCallback() {
        return new FlatFileHeaderCallback() {
            @Override
            public void writeHeader(Writer writer) throws IOException {
                writer.append("name;email;birth;age;id");
            }
        };
    }

    private ResourceSuffixCreator suffixCreator() {
        return new ResourceSuffixCreator() {
            @Override
            public String getSuffix(int index) {
                return index + ".txt" ;
            }
        };
    }
}
