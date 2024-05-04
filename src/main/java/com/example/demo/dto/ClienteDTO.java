package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    @Size(min = 9,max = 9)
    private String telefono;
    @NotNull
    @Size(min = 8 ,max = 8)
    private String dni;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String direccion;

}
