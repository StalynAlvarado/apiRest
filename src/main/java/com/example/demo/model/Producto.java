package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idProducto;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private double precio;
	@ManyToOne
	@JoinColumn(name = "idCategoria" ,nullable = false)
	private Categoria categoria;
	@Column
	private String descripcion;
	@Column
	private boolean activo;
	
	


	
}
