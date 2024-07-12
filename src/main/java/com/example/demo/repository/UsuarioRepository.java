package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByUsername(String username);

}
