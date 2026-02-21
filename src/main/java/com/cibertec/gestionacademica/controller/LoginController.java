package com.cibertec.gestionacademica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.cibertec.gestionacademica.model.Usuario;
import com.cibertec.gestionacademica.service.UsuarioService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UsuarioService usuarioService;

    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping({"/", "/login"})
    public String mostrarLogin() {
        return "login"; // Vista login.html
    }

    @PostMapping("/login")
    public String iniciarSesion(@RequestParam String username, 
                                @RequestParam String password, 
                                HttpSession session, 
                                Model model) {
        Usuario usuario = usuarioService.login(username, password);
        
        if (usuario != null) {
            session.setAttribute("usuarioLogueado", usuario);
            // Ruteo por roles
            if ("Admin".equals(usuario.getRol())) return "redirect:/dashboard/admin";
            if ("Docente".equals(usuario.getRol())) return "redirect:/dashboard/docente";
            return "redirect:/dashboard/estudiante";
        }
        
        model.addAttribute("error", "Credenciales incorrectas");
        return "login";
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}