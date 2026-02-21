package com.cibertec.gestionacademica.service;

import org.springframework.stereotype.Service;
import com.cibertec.gestionacademica.model.Estudiante;
import com.cibertec.gestionacademica.repository.EstudianteRepository;
import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    public void guardar(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    public Estudiante buscarPorId(Integer id) {
        return estudianteRepository.findById(id).orElse(null);
    }
    
    public Estudiante buscarPorDni(String dni) {
        return estudianteRepository.findByDni(dni).orElse(null);
    }

    public void eliminar(Integer id) {
        estudianteRepository.deleteById(id);
    }
}