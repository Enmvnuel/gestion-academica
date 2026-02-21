package com.cibertec.gestionacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.gestionacademica.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}