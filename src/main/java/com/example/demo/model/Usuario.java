package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	@Column(nullable = false,length = 100)
	private String nombre;
	@Column(unique = true,nullable = false)
	private String username;
	@Column(nullable = false,length = 100)
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_rol",
		joinColumns =@JoinColumn(referencedColumnName = "idUsuario",name = "idUser")
		,inverseJoinColumns = @JoinColumn(referencedColumnName = "idRol",name="idRole"))
	private Set<Rol> roles;
	private boolean activo;
	

}
