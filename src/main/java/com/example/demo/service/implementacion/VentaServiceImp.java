package com.example.demo.service.implementacion;

import com.example.demo.model.Venta;
import com.example.demo.repository.VentaRepository;
import com.example.demo.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VentaServiceImp implements VentaService {

    private final VentaRepository repository;

    @Override
    public List<Venta> findAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public Venta insert(Venta venta) throws Exception {
        return repository.save(venta);
    }

    @Override
    public Venta update(Venta venta, Integer id) throws Exception {
        venta.setIdVenta(id);
        return repository.save(venta);
    }

    @Override
    public void delete(Integer id) throws Exception {
repository.deleteById(id);
    }

    @Override
    public Optional<Venta> findById(Integer id) throws Exception {
        return repository.findById(id);
    }
}
