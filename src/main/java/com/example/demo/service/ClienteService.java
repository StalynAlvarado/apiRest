package com.example.demo.service;


import com.example.demo.model.Cliente;

import java.util.List;
import java.util.Optional;


public interface ClienteService {

    List<Cliente> findAll()throws Exception;
    Cliente insert(Cliente cliente)throws Exception;
    Cliente update(Cliente cliente,Integer id)throws Exception;
    void delete(Integer id)throws Exception;
    Optional<Cliente> findById(Integer id)throws Exception;
}
