package dev.kaykyfreitas.databasecsv.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankData {

    @Id
    private Integer id;

    @Column(name = "person_id")
    private Integer personId;

    @Column
    private Integer agency;

    @Column
    private Integer account;

    @Column
    private Integer bank;

}
