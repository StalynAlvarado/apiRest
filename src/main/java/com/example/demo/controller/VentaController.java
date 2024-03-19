package com.example.demo.controller;

import com.example.demo.model.Venta;
import com.example.demo.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/venta")
public class VentaController {

    private final VentaService service;
    @GetMapping
    public ResponseEntity<List<Venta>>listar() throws Exception {
        List<Venta>list=service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Venta>> buscar(@PathVariable("id")Integer id ) throws Exception {
       Optional<Venta> venta=service.findById(id);
        return ResponseEntity.ok(venta);
    }
    @PostMapping
    public ResponseEntity<Venta> agregar(@RequestBody Venta venta)throws Exception{
        Venta ven=service.insert(venta);
     return    ResponseEntity.status(201).body(ven);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Venta> actualizar(@PathVariable("id") Venta venta,Integer id)throws Exception{
        Venta ven=service.insert(venta);
        return ResponseEntity.status(200).body(ven);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Venta> eliminar(Integer id)throws Exception{
        service.delete(id);
        return ResponseEntity.status(200).build();
    }


}
