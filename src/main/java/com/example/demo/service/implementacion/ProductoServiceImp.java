package com.example.demo.service.implementacion;


import com.example.demo.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class   ProductoServiceImp implements ProductoService {


	private final ProductoRepository repoPro;
	
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
	public Page<Producto> findAll(Pageable pageable) {
		return repoPro.findAll(pageable);
	}

	@Override
	public List<Producto> buscarProductoPorNombre(String nombre) {
		return repoPro.buscarProductoPorNombre(nombre);
	}


	@Override
	public Producto update(Producto producto, Integer idPro) {
		producto.setIdProducto(idPro);
		return repoPro.save(producto);
		
	}


	@Override
	public List<Producto> buscarProductosPorCategoria(String nombreCategoria) {
		
		return repoPro.buscarProductosPorCategoria(nombreCategoria);
	}

	
}
