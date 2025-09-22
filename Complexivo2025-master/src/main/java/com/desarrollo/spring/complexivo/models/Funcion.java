package com.desarrollo.spring.complexivo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Funcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Pelicula pelicula;

    private LocalDateTime HoraInicio;
    private LocalDateTime HoraFin;

    private String estado; // pendiente, confirmada, cancelada

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public LocalDateTime getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.HoraInicio = horaInicio;
    }

    public LocalDateTime getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.HoraFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
