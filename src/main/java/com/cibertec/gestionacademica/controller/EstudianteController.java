package com.cibertec.gestionacademica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.cibertec.gestionacademica.model.Estudiante;
import com.cibertec.gestionacademica.service.EstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estudiantes", estudianteService.listarTodos());
        return "mantenimientos/estudiantes/lista_estudiantes";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "mantenimientos/estudiantes/form_estudiante";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Estudiante estudiante, RedirectAttributes attributes) {
        estudianteService.guardar(estudiante);
        attributes.addFlashAttribute("mensaje", "Estudiante guardado con éxito");
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Estudiante estudiante = estudianteService.buscarPorId(id);
        model.addAttribute("estudiante", estudiante);
        return "mantenimientos/estudiantes/form_estudiante";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes attributes) {
        estudianteService.eliminar(id);
        attributes.addFlashAttribute("mensaje", "Estudiante eliminado con éxito");
        return "redirect:/estudiantes";
    }
}