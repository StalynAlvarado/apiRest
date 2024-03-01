package com.example.demo.controller;

import java.util.Collection;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;




@RestController
@RequestMapping("/producto")
public class ProductoRestController {


	public ProductoRestController(ProductoService serProducto) {
		this.serProducto = serProducto;
	}

	private final ProductoService serProducto;
	
	@GetMapping("/listar")
	public ResponseEntity<Collection<Producto>>listar(){
		Collection<Producto>iProducto=serProducto.findAll();
		return new ResponseEntity<>(iProducto,HttpStatus.OK);
		
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
