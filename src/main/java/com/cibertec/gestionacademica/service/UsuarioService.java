package com.cibertec.gestionacademica.service;

import org.springframework.stereotype.Service;
import com.cibertec.gestionacademica.model.Usuario;
import com.cibertec.gestionacademica.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // logica del login
    public Usuario login(String username, String password) {
        Usuario usuario = usuarioRepository.findByUsername(username).orElse(null);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        return null;
    }
    
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}