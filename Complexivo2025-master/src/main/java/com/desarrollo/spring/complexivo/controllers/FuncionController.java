package com.desarrollo.spring.complexivo.controllers;

import com.desarrollo.spring.complexivo.models.Funcion;
import com.desarrollo.spring.complexivo.services.ClienteService;
import com.desarrollo.spring.complexivo.services.PeliculaService;
import com.desarrollo.spring.complexivo.services.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/funciones")
public class FuncionController {

    @Autowired
    FuncionService service;

    @Autowired
    PeliculaService peliculaService;

    @Autowired
    ClienteService clienteService;

    // Mostrar formulario de nueva funcion
    @GetMapping("/nueva")
    public String getFormReserva(@ModelAttribute Funcion funcion, Model model) {
        model.addAttribute("funcion", funcion);
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("peliculas", peliculaService.findAll());
        return "funciones/formFuncion"; // <-- usamos el mismo archivo
    }

    // Guardar nueva reserva
    @PostMapping("/nueva")
    public RedirectView saveReserva(@ModelAttribute Funcion funcion) {
        service.save(funcion);
        return new RedirectView("/funciones/lista");
    }

    // Listar todas las funciones
    @GetMapping("/lista")
    public String listarFunciones(Model model) {
        model.addAttribute("funciones", service.findAll());
        return "funciones/lista";
    }

    // Formulario para editar la funcion
    @GetMapping("/editar/{id}")
    public String editarFuncion(@PathVariable Long id, Model model) {
        Funcion funcion = service.findById(id);
        model.addAttribute("funcion", funcion);
        model.addAttribute("clientes", clienteService.findAll());
        model.addAttribute("habitaciones", peliculaService.findAll());
        return "funciones/formFuncion"; // <-- mismo archivo "nueva.html"
    }

    // Guardar cambios de edición
    @PostMapping("/editar/{id}")
    public RedirectView actualizarFuncion (@PathVariable Long id, @ModelAttribute Funcion funcion) {
        funcion.setId(id); // asegurar que actualice el mismo registro
        service.save(funcion);
        return new RedirectView("/funciones/lista");
    }

    // Eliminar funcion
    @GetMapping("/eliminar/{id}")
    public RedirectView eliminarFuncion (@PathVariable Long id) {
        service.deleteById(id);
        return new RedirectView("/funciones/lista");
    }
}

