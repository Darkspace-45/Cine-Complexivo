package com.desarrollo.spring.complexivo.services;

import com.desarrollo.spring.complexivo.models.Pelicula;
import com.desarrollo.spring.complexivo.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    // Guardar Pelicula
    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    // Listar todas las peliculas
    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    // Buscar por ID
    public Pelicula findById(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    // Eliminar por ID
    public void deleteById(Long id) {
        peliculaRepository.deleteById(id);
    }
}
