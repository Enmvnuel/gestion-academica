package com.cibertec.gestionacademica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cibertec.gestionacademica.model.Docente;
import com.cibertec.gestionacademica.service.DocenteService;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

    private final DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("docentes", docenteService.listarTodos());
        return "mantenimientos/docentes/lista_docentes";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("docente", new Docente());
        return "mantenimientos/docentes/form_docente";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Docente docente) {
        docenteService.guardar(docente);
        return "redirect:/docentes";
    }
}