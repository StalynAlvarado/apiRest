package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Productos")
public class Producto {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idPro;
	@Column
	private String nombre;
	@Column
	private double precio;
	@Column
	private String tipo;
	@Column
	private String descripcion;
	
	public Producto() {
	
	}
	
	public Producto(Producto producto)
	{
		this(producto.getIdPro(),producto.getNombre(),producto.getPrecio(),producto.getTipo(),
				producto.getDescripcion());
	}



	public Producto(Integer idPro, String nombre, double precio, String tipo, String descripcion) {
		super();
		this.idPro = idPro;
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	
	

	public Integer getIdPro() {
		return idPro;
	}

	public void setIdPro(Integer idPro) {
		this.idPro = idPro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	
}
