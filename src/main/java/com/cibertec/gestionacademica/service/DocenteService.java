package com.cibertec.gestionacademica.service;

import org.springframework.stereotype.Service;
import com.cibertec.gestionacademica.model.Docente;
import com.cibertec.gestionacademica.repository.DocenteRepository;
import java.util.List;

@Service
public class DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    public List<Docente> listarTodos() {
        return docenteRepository.findAll();
    }

    public void guardar(Docente docente) {
        docenteRepository.save(docente);
    }

    public Docente buscarPorId(Integer id) {
        return docenteRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        docenteRepository.deleteById(id);
    }
}