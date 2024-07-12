package com.example.demo.controller;


import com.example.demo.dto.ProductoDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import java.util.List;


@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoRestController {

	private final ProductoService serProducto;

	@Qualifier("default")
	private final ModelMapper mapper;
	
	@GetMapping("/listar")
	public ResponseEntity<Page<ProductoDTO>>listar(@RequestParam(defaultValue = "10") int size,@RequestParam("page") int page){

		Page<ProductoDTO> pro = serProducto.findAll(PageRequest.of(page,size))
						.map(p->mapper.map(p,ProductoDTO.class));

		return  ResponseEntity.status(200).body(pro);
		
	}
	 @GetMapping("/buscar/{idPro}")
	 public ResponseEntity<ProductoDTO>buscar(@PathVariable Integer idPro){
		 Producto producto=serProducto.findById(idPro);
		 if(producto!=null) {
			 return new ResponseEntity<>(mapper.map(producto,ProductoDTO.class),HttpStatus.OK);
			 
		 }
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
	 }
	 
	 @PostMapping("/agregar")
	 public ResponseEntity<ProductoDTO>agregar(@Valid @RequestBody ProductoDTO producto){
		 
		 serProducto.insert(mapper.map(producto,Producto.class));
		 return new ResponseEntity<>(HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/editar/{idPro}")
	 public ResponseEntity<ProductoDTO>editar(@Valid @PathVariable Integer idPro,@RequestBody
			 ProductoDTO pro){
		Producto producto=serProducto.findById(idPro);
		 if(producto!=null) {
		
			 serProducto.update(mapper.map(pro,Producto.class),idPro);
			 return new ResponseEntity<>(HttpStatus.OK);
			 
		 }

		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	 @DeleteMapping("/borrar/{idPro}")
	 public ResponseEntity<Void>borrar(@PathVariable Integer idPro){
	 
		Producto producto=serProducto.findById(idPro);
		if(producto!=null) {
		serProducto.delete(idPro);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/search")
	public ResponseEntity<List<ProductoDTO>> buscarProductoPorNombre(@RequestParam(name = "nombre") String nombre){

	List<Producto> list=serProducto.buscarProductoPorNombre(nombre);
	List<ProductoDTO>dtoList= list.stream()
			.map(p->mapper.map(p,ProductoDTO.class))
			.toList();
		return ResponseEntity.ok(dtoList);
	}
	
	@GetMapping("/search/categoria")
	public ResponseEntity<List<ProductoDTO>> buscarProductoPorCategoria(@RequestParam(name = "nombre") String nombre){

	List<Producto> list=serProducto.buscarProductosPorCategoria(nombre);
	List<ProductoDTO>dtoList= list.stream()
			.map(p->mapper.map(p,ProductoDTO.class))
			.toList();
		return ResponseEntity.ok(dtoList);
	}
}
