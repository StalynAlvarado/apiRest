package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImp implements CategoriaService{

    private final CategoriaRepository repository;


    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Override
    public Categoria insert(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria, Integer id) throws Exception {
        categoria.setIdCategoria(id);
        return repository.save(categoria);
    }

    @Override
    public void delete(Integer id) throws Exception {
repository.deleteById(id);
    }

    @Override
    public Optional<Categoria> findById(Integer id) throws Exception {

        Optional<Categoria> categoria= repository.findById(id);
        if (categoria.isPresent()) {
            return categoria;
        }
        else {
            throw new NoSuchElementException("No existe la categoria: "+id);
        }
    }


}
