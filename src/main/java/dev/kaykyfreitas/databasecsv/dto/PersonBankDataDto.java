package dev.kaykyfreitas.databasecsv.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonBankDataDto {

    private String name;
    private String email;
    private Date birth;
    private Integer age;
    private Integer bankId;
    private Integer personId;
    private Integer agency;
    private Integer account;
    private Integer bank;
}
