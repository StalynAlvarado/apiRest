package com.example.demo.repository;

import com.example.demo.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Integer> {
}
