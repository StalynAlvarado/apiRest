package com.example.demo.service.implementacion;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImp implements ClienteService {

private final ClienteRepository repository;


    @Override
    public List<Cliente> findAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public Cliente insert(Cliente cliente) throws Exception {
        return repository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente, Integer id) throws Exception {
        cliente.setIdCliente(id);
        return repository.save(cliente);
    }

    @Override
    public void delete(Integer id) throws Exception {
repository.deleteById(id);
    }

    @Override
    public Optional<Cliente> findById(Integer id) throws Exception {
        return repository.findById(id);
    }

	@Override
	public Cliente findByDni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return repository.findByDni(dni);
	}
}
