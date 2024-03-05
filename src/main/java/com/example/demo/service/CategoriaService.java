package com.example.demo.service;

import com.example.demo.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> findAll()throws Exception;
    Categoria insert(Categoria categoria)throws Exception;
    Categoria update(Categoria categoria,Integer id)throws Exception;
    void delete(Integer id)throws Exception;
    Optional<Categoria> findById(Integer id)throws Exception;
}
