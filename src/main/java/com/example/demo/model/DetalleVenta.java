package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "idVenta")
    private Venta venta;
    private int cantidad;
    private double total;
}
