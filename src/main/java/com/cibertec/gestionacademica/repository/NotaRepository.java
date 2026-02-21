package com.cibertec.gestionacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.gestionacademica.model.Nota;
import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Integer> {
    List<Nota> findByEstudianteId(Integer estudianteId);
}