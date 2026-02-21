package com.cibertec.gestionacademica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.cibertec.gestionacademica.model.Matricula;
import com.cibertec.gestionacademica.service.MatriculaService;
import com.cibertec.gestionacademica.service.EstudianteService;
import com.cibertec.gestionacademica.service.CursoService;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final EstudianteService estudianteService;
    private final CursoService cursoService;

    public MatriculaController(MatriculaService matriculaService,
                               EstudianteService estudianteService,
                               CursoService cursoService) {
        this.matriculaService = matriculaService;
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
    }

    @GetMapping("/nueva")
    public String nuevaMatricula(Model model, jakarta.servlet.http.HttpSession session) {
        Matricula matricula = new Matricula();

        //  obtiene el usuario en sesion
        com.cibertec.gestionacademica.model.Usuario usuario = (com.cibertec.gestionacademica.model.Usuario) session.getAttribute("usuarioLogueado");

        if (usuario != null && "Estudiante".equals(usuario.getRol())) {
            // si es estudiante, buscar su perfil y asignarlo automaticamente
            com.cibertec.gestionacademica.model.Estudiante estudianteLogueado = estudianteService.listarTodos()
                .stream()
                .filter(e -> e.getUsuario() != null && e.getUsuario().getId().equals(usuario.getId()))
                .findFirst()
                .orElse(null);

            if (estudianteLogueado != null) {
                matricula.setEstudiante(estudianteLogueado);
                // solo le pasamos su propio perfil a la vista para que no vea a los demas
                model.addAttribute("estudiantes", java.util.Collections.singletonList(estudianteLogueado));
            }
        } else {
            // si es Admin, mostramos todos los estudiantes normalmente
            model.addAttribute("estudiantes", estudianteService.listarTodos());
        }

        model.addAttribute("matricula", matricula);
        model.addAttribute("cursos", cursoService.listarTodos());
        return "transaccion/registro_matricula";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Matricula matricula, RedirectAttributes attributes) {
        matriculaService.registrarMatricula(matricula);
        attributes.addFlashAttribute("mensaje", "Matrícula registrada con éxito");
        return "redirect:/matriculas/nueva";
    }
}