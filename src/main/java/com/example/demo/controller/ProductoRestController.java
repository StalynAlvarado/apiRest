package com.example.demo.controller;

import java.util.Collection;


import org.hibernate.engine.jdbc.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;




@RestController
@RequestMapping("/producto")
public class ProductoRestController {


	public ProductoRestController(ProductoService serProducto) {
		this.serProducto = serProducto;
	}

	private final ProductoService serProducto;
	
	@GetMapping("/listar/{page}")
	public ResponseEntity<Page<Producto>>listar(@RequestParam(defaultValue = "10") int size,@PathVariable("page") int page){

		Page<Producto> pro =serProducto.findAll(PageRequest.of(page,size));
		return  ResponseEntity.status(200).body(pro);
		
	}
	 @GetMapping("/buscar/{idPro}")
	 public ResponseEntity<Producto>buscar(@PathVariable Integer idPro){
		 Producto producto=serProducto.findById(idPro);
		 if(producto!=null) {
			 return new ResponseEntity<>(producto,HttpStatus.OK);
			 
		 }
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
	 }
	 
	 @PostMapping("/agregar")
	 public ResponseEntity<Producto>agregar(@RequestBody Producto producto){
		 
		 serProducto.insert(producto);
		 return new ResponseEntity<>(HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/editar/{idPro}")
	 public ResponseEntity<Producto>editar(@PathVariable Integer idPro,@RequestBody
			 Producto pro){
		Producto producto=serProducto.findById(idPro);
		 if(producto!=null) {
		
			 serProducto.update(pro,idPro);
			 return new ResponseEntity<>(HttpStatus.OK);
			 
		 }

		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	 @DeleteMapping("/borrar/{idPro}")
	 public ResponseEntity<Producto>borrar(@PathVariable Integer idPro){
	 
Producto producto=serProducto.findById(idPro);
if(producto!=null) {
	serProducto.delete(idPro);
	return new ResponseEntity<>(HttpStatus.OK);
}
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
