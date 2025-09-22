package com.desarrollo.spring.complexivo.controllers;

import com.desarrollo.spring.complexivo.models.Pelicula;
import com.desarrollo.spring.complexivo.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    // Mostrar lista de peliculas
    @GetMapping("/lista")
    public String listarHabitaciones(Model model) {
        model.addAttribute("peliculas", peliculaService.findAll());
        return "peliculas/lista";
    }

    // Formulario nuevo
    @GetMapping("/nuevo")
    public String formNuevaPelicula(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas/formPelicula";
    }

    // Formulario editar
    @GetMapping("/editar/{id}")
    public String formEditarPelicula(@PathVariable Long id, Model model) {
        Pelicula pelicula = peliculaService.findById(id);
        model.addAttribute("pelicula", pelicula);
        return "peliculas/formPelicula";
    }

    // Guardar nueva pelicula
    @PostMapping("/nuevo")
    public RedirectView guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.save(pelicula);
        return new RedirectView("/peliculas/lista");
    }

    // Actualizar pelicula existente
    @PostMapping("/editar/{id}")
    public RedirectView actualizarPelicula(@PathVariable Long id, @ModelAttribute Pelicula pelicula) {
        pelicula.setId(id);
        peliculaService.save(pelicula);
        return new RedirectView("/peliculas/lista");
    }

    // Eliminar pelicula
    @GetMapping("/eliminar/{id}")
    public RedirectView eliminarPelicula (@PathVariable Long id) {
        peliculaService.deleteById(id);
        return new RedirectView("/peliculas/lista");
    }
}
