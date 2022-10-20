package dev.kaykyfreitas.databasecsv.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InputFile {

    private Integer id;
    private String username;
    private String phone;
    private String email;

}
