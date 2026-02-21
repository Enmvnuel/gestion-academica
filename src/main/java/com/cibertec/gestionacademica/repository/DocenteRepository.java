package com.cibertec.gestionacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.gestionacademica.model.Docente;
import java.util.Optional;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {
    Optional<Docente> findByDni(String dni);
}