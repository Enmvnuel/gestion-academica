package com.cibertec.gestionacademica.service;

import org.springframework.stereotype.Service;
import com.cibertec.gestionacademica.model.Matricula;
import com.cibertec.gestionacademica.model.Nota;
import com.cibertec.gestionacademica.model.Estudiante;
import com.cibertec.gestionacademica.repository.MatriculaRepository;
import com.cibertec.gestionacademica.repository.NotaRepository;
import com.cibertec.gestionacademica.repository.EstudianteRepository;
import java.util.List;
import java.util.ArrayList;

@Service
public class ConsultaService {

    private final MatriculaRepository matriculaRepository;
    private final NotaRepository notaRepository;
    private final EstudianteRepository estudianteRepository;

    public ConsultaService(MatriculaRepository matriculaRepository, 
                           NotaRepository notaRepository,
                           EstudianteRepository estudianteRepository) {
        this.matriculaRepository = matriculaRepository;
        this.notaRepository = notaRepository;
        this.estudianteRepository = estudianteRepository;
    }

    // consulta 1: buscar matriculas por dni del estudiante
    public List<Matricula> buscarMatriculasPorDni(String dni) {
        Estudiante estudiante = estudianteRepository.findByDni(dni).orElse(null);
        if (estudiante != null) {
            return matriculaRepository.findByEstudianteId(estudiante.getId());
        }
        return new ArrayList<>();
    }

    // consulta 2: consultar record de notas por ID del estudiante (para su dashboard)
    public List<Nota> consultarNotasPorEstudiante(Integer estudianteId) {
        return notaRepository.findByEstudianteId(estudianteId);
    }
}