package com.cibertec.gestionacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.gestionacademica.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    // Con los métodos básicos (save, findAll, deleteById) es suficiente para el CRUD
}