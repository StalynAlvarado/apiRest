package com.example.demo.service;

import com.example.demo.model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService {

	Producto insert(Producto producto);
	 Producto update(Producto producto,Integer idPro);
	 void delete(Integer idPro);
	 Producto findById(Integer idPro);
	Page<Producto> findAll(Pageable pageable);
	List<Producto> buscarProductoPorNombre(String nombre);
	List<Producto> buscarProductosPorCategoria(String nombreCategoria);
}
