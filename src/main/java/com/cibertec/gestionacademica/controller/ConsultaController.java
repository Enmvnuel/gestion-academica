package com.cibertec.gestionacademica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cibertec.gestionacademica.service.ConsultaService;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping("/matricula")
    public String buscarMatricula(@RequestParam(required = false) String dni, Model model) {
        if (dni != null && !dni.isEmpty()) {
            model.addAttribute("resultados", consultaService.buscarMatriculasPorDni(dni));
        }
        return "consultas/buscar_matricula";
    }

    @GetMapping("/notas/{estudianteId}")
    public String consultarNotas(@PathVariable Integer estudianteId, Model model) {
        model.addAttribute("notas", consultaService.consultarNotasPorEstudiante(estudianteId));
        return "consultas/consulta_notas";
    }
}