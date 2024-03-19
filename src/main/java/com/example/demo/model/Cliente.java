package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(nullable = false,length = 50)
    private String nombre;
    @Column(nullable = false,length = 50)
    private String apellido;
    @Column(nullable = false,length = 9)
    private String telefono;
    @Column(nullable = false,length = 8)
    private String dni;
    @Column(nullable = false,length = 50)
    private String email;
    @Column(nullable = false,length = 50)
    private String direccion;

}
