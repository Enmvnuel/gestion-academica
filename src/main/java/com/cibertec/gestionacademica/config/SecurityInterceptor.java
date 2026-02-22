package com.cibertec.gestionacademica.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        // Protegemos las rutas de mantenimientos (cursos, docentes, estudiantes)
        if (uri.startsWith("/mantenimientos")) {
            
            HttpSession session = request.getSession();
            Object usuarioLogueado = session.getAttribute("usuarioLogueado");
            String rol = (String) session.getAttribute("rol"); 

            // Si no hay sesion, al login
            if (usuarioLogueado == null) {
                response.sendRedirect("/login");
                return false;
            }

            // Solo el Admin puede entrar a mantenimientos
            if (!"Admin".equals(rol)) {
                response.sendRedirect("/login"); 
                return false;
            }
        }
        return true;
    }
}