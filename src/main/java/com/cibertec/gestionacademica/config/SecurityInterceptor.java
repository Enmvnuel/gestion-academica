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

        HttpSession session = request.getSession();
        Object usuarioLogueado = session.getAttribute("usuarioLogueado");
        String rol = (String) session.getAttribute("rol");

        // Si no hay sesion, al login
        if (usuarioLogueado == null) {
            response.sendRedirect("/login");
            return false;
        }

        // Solo el Admin puede acceder a las rutas de cursos, docentes y estudiantes
        if (!"Admin".equals(rol)) {
            response.sendRedirect("/login");
            return false;
        }

        return true;
    }
}