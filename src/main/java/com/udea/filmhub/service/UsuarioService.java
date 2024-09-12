package com.udea.filmhub.service;
import com.udea.filmhub.model.Usuario;
import com.udea.filmhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario createUsuario(Usuario usuario) {
        // Aquí iría la lógica de validación y encriptación de contraseña
        return usuarioRepository.save(usuario);
    }
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
    // Otros métodos según sea necesario
}