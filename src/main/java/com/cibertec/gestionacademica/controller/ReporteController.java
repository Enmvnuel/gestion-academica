package com.cibertec.gestionacademica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.cibertec.gestionacademica.util.JasperReportManager;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    private final JasperReportManager reportManager;

    public ReporteController(JasperReportManager reportManager) {
        this.reportManager = reportManager;
    }

    @GetMapping("/matriculados")
    public void reporteMatriculados(HttpServletResponse response) {
        try {
            reportManager.exportarPdf("/reportes/reporte_matriculados.jrxml", new HashMap<>(), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/notas")
    public void reporteNotas(HttpServletResponse response) {
        try {
            reportManager.exportarPdf("/reportes/reporte_notas.jrxml", new HashMap<>(), response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}