package com.example.demo.repository;

import com.example.demo.model.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

	Cliente findByDni(String dni);
	
}
