package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface VentaService  {
    List<Venta> findAll()throws Exception;
    Venta insert(Venta venta)throws Exception;
    Venta update(Venta venta,Integer id)throws Exception;
    void delete(Integer id)throws Exception;
    Optional<Venta> findById(Integer id)throws Exception;
}
