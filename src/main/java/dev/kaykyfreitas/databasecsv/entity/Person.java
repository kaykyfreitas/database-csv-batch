package dev.kaykyfreitas.databasecsv.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Date birth;

    @Column
    private Integer age;

    @Column
    private Integer bankId;

}
