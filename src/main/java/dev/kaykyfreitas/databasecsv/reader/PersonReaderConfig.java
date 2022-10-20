package dev.kaykyfreitas.databasecsv.reader;

import dev.kaykyfreitas.databasecsv.entity.Person;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class PersonReaderConfig {

    @Bean
    public JdbcCursorItemReader<Person> personReader(
            @Qualifier("appDataSource") DataSource dataSource
    ) {
        return new JdbcCursorItemReaderBuilder<Person>()
                .name("personReader")
                .dataSource(dataSource)
                .sql("SELECT * FROM person")
                .rowMapper(rowMapperTransaction())
                .build();
    }

    private RowMapper<Person> rowMapperTransaction() {
        return new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person person = new Person();
                person.setName(rs.getString("name"));
                person.setAge(rs.getInt("age"));
                person.setEmail(rs.getString("email"));
                person.setBirth(rs.getDate("birth"));
                person.setId(rs.getInt("id"));
                return person;
            }
        };
    }

}
