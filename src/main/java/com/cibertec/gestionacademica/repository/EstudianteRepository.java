package com.cibertec.gestionacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.gestionacademica.model.Estudiante;
import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    Optional<Estudiante> findByDni(String dni);
}