package com.cibertec.gestionacademica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping("/admin")
    public String panelAdmin(HttpSession session) {

        if (session.getAttribute("usuarioLogueado") == null) return "redirect:/login";
        
        return "dashboard/home_admin";
    }

    @GetMapping("/docente")
    public String panelDocente(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) return "redirect:/login";
        
        return "dashboard/home_docente"; 
    }

    @GetMapping("/estudiante")
    public String panelEstudiante(HttpSession session, Model model) {
    
        com.cibertec.gestionacademica.model.Usuario usuario = (com.cibertec.gestionacademica.model.Usuario) session.getAttribute("usuarioLogueado");

        if (usuario == null) return "redirect:/login";

        int estudianteIdReal;
        
        if (usuario.getUsername().equals("jperez")) {
            estudianteIdReal = 1; 
        } else if (usuario.getUsername().equals("mgomez")) {
            estudianteIdReal = 2; 
        } else {
            estudianteIdReal = usuario.getId(); 
        }

        model.addAttribute("estudianteId", estudianteIdReal);
        
        return "dashboard/home_estudiante"; 
    }
}