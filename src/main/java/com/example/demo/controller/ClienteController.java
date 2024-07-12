package com.example.demo.controller;

import com.example.demo.dto.ClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @Qualifier("default")
    private final ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar() throws Exception {
       List<ClienteDTO> list= service.findAll().stream()
               .map(c->mapper.map(c,ClienteDTO.class)).toList();
        return ResponseEntity.status(200).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteDTO>> buscar(@PathVariable("id")Integer id) throws Exception {
        Optional<Cliente> cliente= service.findById(id);
        return ResponseEntity.status(200).body(Optional.ofNullable(mapper.map(cliente, ClienteDTO.class)));
    }
    
    @GetMapping("/search")
    public ResponseEntity<ClienteDTO> buscarClientePorDni(@RequestParam(name = "dni")String dni) throws Exception{
    	
    	Cliente cliente=service.findByDni(dni);
    	return ResponseEntity.status(200).body(mapper.map(cliente,ClienteDTO.class));
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> agregar(@Valid @RequestBody ClienteDTO cliente)throws Exception{
        Cliente cli=service.insert(mapper.map(cliente,Cliente.class));
        return ResponseEntity.status(201).body(mapper.map(cli,ClienteDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> actualizar(@Valid @RequestBody ClienteDTO cliente,@PathVariable("id")Integer id)throws Exception{
        Cliente cli=service.update(mapper.map(cliente,Cliente.class),id);
        return ResponseEntity.status(200).body(mapper.map(cli,ClienteDTO.class));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id)throws Exception{
        service.delete(id);
        return ResponseEntity.status(204).build();
    }


}
