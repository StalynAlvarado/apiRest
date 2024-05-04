package com.example.demo.controller;

import com.example.demo.dto.CategoriaDTO;
import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {


    private final CategoriaService service;
@Qualifier("default")
    private final ModelMapper mapper;


    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listar()throws Exception{
      List<CategoriaDTO> list= service.findAll()
              .stream()
              .map(c-> mapper.map(c, CategoriaDTO.class))
              .toList();
        return  ResponseEntity.status(200).body(list);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> agregar(@Valid @RequestBody CategoriaDTO categoria)throws Exception{

       Categoria cat =service.insert(mapper.map(categoria,Categoria.class));

         return  ResponseEntity.status(201).body(mapper.map(cat,CategoriaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@Valid @RequestBody CategoriaDTO categoria,@PathVariable("id") Integer id)throws Exception{

service.update(mapper.map(categoria, Categoria.class),id);
return ResponseEntity.status(200).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<CategoriaDTO>>buscar(@PathVariable("id") Integer id)throws Exception{

       Optional<Categoria> cat=service.findById(id);
      return  ResponseEntity.status(200).body(Optional.ofNullable(mapper.map(cat, CategoriaDTO.class)));

    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void>eliminar(@PathVariable("id")Integer id)throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
