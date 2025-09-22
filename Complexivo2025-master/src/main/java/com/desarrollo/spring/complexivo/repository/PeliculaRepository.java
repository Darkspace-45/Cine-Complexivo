package com.desarrollo.spring.complexivo.repository;

import com.desarrollo.spring.complexivo.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula,Long> {
}
