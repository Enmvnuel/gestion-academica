package com.cibertec.gestionacademica.util;

import org.springframework.stereotype.Component;
import net.sf.jasperreports.engine.*;
import javax.sql.DataSource;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;

@Component
public class JasperReportManager {

    private final DataSource dataSource;

    public JasperReportManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void exportarPdf(String reportPath, Map<String, Object> params, HttpServletResponse response) throws Exception {
        // 1. se obtiene la conexion a la BD
        try (Connection conn = dataSource.getConnection()) {
            // 2. lee el archivo jasper/jrxml desde la carpeta resources/reportes
            InputStream reportStream = getClass().getResourceAsStream(reportPath);
            if (reportStream == null) {
                throw new RuntimeException("No se encontró el reporte en: " + reportPath);
            }

            // 3. compila y llena el reporte
            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

            // 4. se configura la respuesta HTTP para descargar/ver en pdf
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=reporte.pdf");

            // 5. exportar al navegador
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        }
    }
}