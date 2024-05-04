package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Producto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "From Producto p where p.nombre like :nombre%")
List<Producto> buscarProductoPorNombre(String nombre);
	
	
}
