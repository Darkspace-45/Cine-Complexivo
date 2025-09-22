package com.desarrollo.spring.complexivo.services;

import com.desarrollo.spring.complexivo.models.Funcion;
import com.desarrollo.spring.complexivo.repository.FuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionService {

    @Autowired
    FuncionRepository funcionRepository;

    // Método para guardar una reserva
    public Funcion save(Funcion funcion) {
        return this.funcionRepository.save(funcion);
    }

    // Método para listar todas las reservas
    public List<Funcion> findAll() {
        return this.funcionRepository.findAll();
    }
    // Método para buscar por ID
    public Funcion findById(Long id) {
        return this.funcionRepository.findById(id).orElse(null);
    }

    // Método para eliminar por ID
    public void deleteById(Long id) {
        this.funcionRepository.deleteById(id);
    }

}
