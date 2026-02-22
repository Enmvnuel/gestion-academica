package com.cibertec.gestionacademica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final SecurityInterceptor securityInterceptor;

    // Inyeccion por Constructor
    public WebConfig(SecurityInterceptor securityInterceptor) {
        this.securityInterceptor = securityInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Registramos el interceptor para que vigile todas las rutas de mantenimientos
        registry.addInterceptor(securityInterceptor)
                .addPathPatterns("/mantenimientos/**");
    }
}