package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    @Column(nullable = false )
    private LocalDateTime fechaVenta;
    @Column(nullable = false )
    private double total;
    @Column(nullable = false )
    private double impuesto;

    @OneToMany(mappedBy = "venta",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleVenta> detalle;

}
