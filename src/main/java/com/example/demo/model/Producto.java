package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	private Integer idPro;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private double precio;
	@Column(nullable = false)
	private String tipo;
	@Column
	private String descripcion;
	
	


	
}
