package com.example.demo.controller;

import com.example.demo.dto.VentaDTO;
import com.example.demo.model.Venta;
import com.example.demo.service.VentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/venta")
public class VentaController {

    private final VentaService service;

    @Qualifier("default")
    private final ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<VentaDTO>>listar() throws Exception {
        List<VentaDTO>list=service.findAll()
                .stream()
                .map(v->mapper.map(v, VentaDTO.class))
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<VentaDTO>> buscar(@PathVariable("id")Integer id ) throws Exception {
       Optional<Venta> venta=service.findById(id);
        return ResponseEntity.ok(Optional.ofNullable(mapper.map(venta, VentaDTO.class)));
    }
    @PostMapping
    public ResponseEntity<VentaDTO> agregar(@Valid @RequestBody VentaDTO venta)throws Exception{
        Venta ven=service.insert(mapper.map(venta, Venta.class));
     return    ResponseEntity.status(201).body(mapper.map(ven,VentaDTO.class));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<VentaDTO> actualizar(@Valid @PathVariable("id") VentaDTO venta,Integer id)throws Exception{
        Venta ven=service.insert(mapper.map(venta,Venta.class));
        return ResponseEntity.status(200).body(mapper.map(ven,VentaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(Integer id)throws Exception{
        service.delete(id);
        return ResponseEntity.status(204).build();
    }


}
