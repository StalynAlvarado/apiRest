package com.example.demo.dto;

import com.example.demo.model.Producto;
import com.example.demo.model.Venta;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaDTO {

    private Integer id;
    @NotNull
    private ProductoDTO producto;

    @JsonBackReference
    @NotNull
    private VentaDTO venta;
    @NotNull
    private int cantidad;
    @NotNull
    private double total;
}
