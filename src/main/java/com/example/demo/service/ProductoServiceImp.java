package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoServiceImp implements ProductoService {

	@Autowired
	private ProductoRepository repoPro;
	
	@Override
	public Producto insert(Producto producto) {
	return 	repoPro.save(producto);

	}


	@Override
	public void delete(Integer idPro) {
		repoPro.deleteById(idPro);
		
	}

	@Override
	public Producto findById(Integer idPro) {
	return	repoPro.findById(idPro).orElse(null);
		
	}

	@Override
	public Collection<Producto> findAll() {

	return (Collection<Producto>)repoPro.findAll();

	}

	@Override
	public Producto update(Producto producto, Integer idPro) {
		producto.setIdPro(idPro);
		return repoPro.save(producto);
		
	}

	
}
