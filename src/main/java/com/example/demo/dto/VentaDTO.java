package com.example.demo.dto;

import com.example.demo.model.Cliente;
import com.example.demo.model.DetalleVenta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {

    private Integer id;
    @NotNull
    private ClienteDTO cliente;
    @NotNull
    private LocalDateTime fechaVenta;
    @NotNull
    private double total;
    @NotNull
    private double impuesto;

    @JsonManagedReference
    @JsonIgnoreProperties("venta")
    private List<DetalleVentaDTO> detalle;

}
