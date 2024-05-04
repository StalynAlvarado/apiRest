package com.example.demo.dto;

import com.example.demo.model.Categoria;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {


	private Integer id;
	@NotNull
	private String nombre;
	@NotNull
	private double precio;
	@JsonIncludeProperties(value = {"id","nombre"})
	@NotNull
	private CategoriaDTO categoria;
	@NotNull
	private String descripcion;
	@NotNull
	private boolean activo;
	
	


	
}
