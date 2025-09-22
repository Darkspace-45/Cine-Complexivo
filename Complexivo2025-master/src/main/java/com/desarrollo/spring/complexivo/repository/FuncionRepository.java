package com.desarrollo.spring.complexivo.repository;

import com.desarrollo.spring.complexivo.models.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionRepository extends JpaRepository<Funcion,Long> {
    List<Funcion> findByPeliculaId(Long peliculaId);
}
