package com.cibertec.gestionacademica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.cibertec.gestionacademica.model.Curso;
import com.cibertec.gestionacademica.service.CursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cursos", cursoService.listarTodos());
        return "mantenimientos/cursos/lista_cursos";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("curso", new Curso());
        return "mantenimientos/cursos/form_curso";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Curso curso, RedirectAttributes attributes) {
        cursoService.guardar(curso);
        attributes.addFlashAttribute("mensaje", "Curso guardado con éxito");
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Curso curso = cursoService.buscarPorId(id);
        model.addAttribute("curso", curso);
        return "mantenimientos/cursos/form_curso";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes attributes) {
        try {
            cursoService.eliminar(id);
            attributes.addFlashAttribute("mensaje", "Curso eliminado con éxito");
        } catch (Exception e) {
            attributes.addFlashAttribute("error",
                    "No se puede eliminar el curso porque está asignado a matrículas o registros asociados.");
        }
        return "redirect:/cursos";
    }
}