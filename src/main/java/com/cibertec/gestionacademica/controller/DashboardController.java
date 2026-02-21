package com.cibertec.gestionacademica.controller;

import org.springframework.stereotype.Controller;
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
    public String panelEstudiante(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) return "redirect:/login";
        
        return "dashboard/home_estudiante"; 
    }
}