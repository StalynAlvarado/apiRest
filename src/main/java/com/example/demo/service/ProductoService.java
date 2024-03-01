package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Producto;

public interface ProductoService {

	 void insert(Producto producto);
	 void update(Producto producto,Integer idPro);
	 void delete(Integer idPro);
	 Producto findById(Integer idPro);
	 Collection<Producto>findAll();
	
}
