package com.cibertec.gestionacademica.service;

import org.springframework.stereotype.Service;
import com.cibertec.gestionacademica.model.Curso;
import com.cibertec.gestionacademica.repository.CursoRepository;
import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public void guardar(Curso curso) {
        cursoRepository.save(curso);
    }

    public Curso buscarPorId(Integer id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        cursoRepository.deleteById(id);
    }
}