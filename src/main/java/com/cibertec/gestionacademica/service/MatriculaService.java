package com.cibertec.gestionacademica.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cibertec.gestionacademica.model.Matricula;
import com.cibertec.gestionacademica.model.DetalleMatricula;
import com.cibertec.gestionacademica.repository.MatriculaRepository;
import java.time.LocalDate;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @Transactional
    public void registrarMatricula(Matricula matricula) {
        // aqui se asegura que la fecha y estado inicial esten seteados
        matricula.setFechaRegistro(LocalDate.now());
        matricula.setEstado("Registrada");

        // proseguimos vinculando cada detalle (los cursos) con esta matricula (la cabecera)
        if (matricula.getDetalles() != null) {
            for (DetalleMatricula detalle : matricula.getDetalles()) {
                detalle.setMatricula(matricula);
            }
        }
        
        // al guardar la cabecera, CascadeType.ALL guardara los detalles automaticamente
        matriculaRepository.save(matricula);
    }
}

