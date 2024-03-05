package com.example.demo.controller;

import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    public final CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar()throws Exception{

      List<Categoria>list= service.findAll();
        return  ResponseEntity.status(200).body(list);
    }

    @PostMapping
    public ResponseEntity<Categoria> agregar(@RequestBody Categoria categoria)throws Exception{


       Categoria cat =service.insert(categoria);
         return  ResponseEntity.status(201).body(cat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@RequestBody Categoria categoria,@PathVariable("id") Integer id)throws Exception{

service.update(categoria,id);
return ResponseEntity.status(200).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Categoria>>buscar(@PathVariable("id") Integer id)throws Exception{

        Optional<Categoria> cat=service.findById(id);
      return  ResponseEntity.status(200).body(cat);

    }
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable("id")Integer id)throws Exception{
        service.delete(id);
    }
}
