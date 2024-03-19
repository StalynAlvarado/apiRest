package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() throws Exception {
       List<Cliente> list= service.findAll();
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> buscar(@PathVariable("id")Integer id) throws Exception {
        Optional<Cliente> cliente= service.findById(id);
        return ResponseEntity.status(200).body(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> agregar(@RequestBody Cliente cliente)throws Exception{
        Cliente cli=service.insert(cliente);
        return ResponseEntity.status(201).body(cli);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente cliente,@PathVariable("id")Integer id)throws Exception{
        Cliente cli=service.update(cliente,id);
        return ResponseEntity.status(200).body(cli);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> eliminar(@PathVariable("id") Integer id)throws Exception{
        service.delete(id);
        return ResponseEntity.status(200).build();
    }


}
