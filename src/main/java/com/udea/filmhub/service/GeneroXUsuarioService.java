package com.udea.filmhub.service;

import com.udea.filmhub.model.Genero;
import com.udea.filmhub.model.GeneroXUsuario;
import com.udea.filmhub.model.Usuario;
import com.udea.filmhub.repository.GeneroRepository;
import com.udea.filmhub.repository.GeneroXUsuarioRepository;
import com.udea.filmhub.repository.UsuarioRepository;
import com.udea.filmhub.dto.GeneroXUsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneroXUsuarioService {

    @Autowired
private UsuarioRepository usuarioRepository;

@Autowired
private GeneroRepository generoRepository;

@Autowired
private GeneroXUsuarioRepository generoXUsuarioRepository;

public GeneroXUsuarioResponse addOrReplaceGeneroForUsuario(Long usuarioId, String generoNombre) {
    Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    Genero genero = generoRepository.findByNombre(generoNombre)
            .orElseThrow(() -> new IllegalArgumentException("Genero no encontrado"));

    // Buscar si el usuario ya tiene un género asignado
    Optional<GeneroXUsuario> existingGeneroXUsuario = generoXUsuarioRepository.findByUsuarioId(usuarioId);

    GeneroXUsuario generoXUsuario;
    if (existingGeneroXUsuario.isPresent()) {
        // Reemplazar el género existente
        generoXUsuario = existingGeneroXUsuario.get();
        generoXUsuario.setGenero(genero);
    } else {
        // Crear una nueva relación
        generoXUsuario = new GeneroXUsuario(usuario, genero);
    }

    generoXUsuarioRepository.save(generoXUsuario);

    return new GeneroXUsuarioResponse(usuario.getId(), usuario.getNombre(), genero.getId(), genero.getNombre());
}

public GeneroXUsuarioResponse addOrReplaceGeneroForUsuario(Long usuarioId, Long generoId) {
    Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    Genero genero = generoRepository.findById(generoId)
            .orElseThrow(() -> new IllegalArgumentException("Genero no encontrado"));

    // Buscar si el usuario ya tiene un género asignado
    Optional<GeneroXUsuario> existingGeneroXUsuario = generoXUsuarioRepository.findByUsuarioId(usuarioId);

    GeneroXUsuario generoXUsuario;
    if (existingGeneroXUsuario.isPresent()) {
        // Reemplazar el género existente
        generoXUsuario = existingGeneroXUsuario.get();
        generoXUsuario.setGenero(genero);
    } else {
        // Crear una nueva relación
        generoXUsuario = new GeneroXUsuario(usuario, genero);
    }

    generoXUsuarioRepository.save(generoXUsuario);

    return new GeneroXUsuarioResponse(usuario.getId(), usuario.getNombre(), genero.getId(), genero.getNombre());
    }

    public void removeGeneroFromUsuario(Long usuarioId, Long generoId) {
        GeneroXUsuario generoXUsuario = generoXUsuarioRepository.findByUsuarioIdAndGeneroId(usuarioId, generoId)
                .orElseThrow(() -> new IllegalArgumentException("Relacion Genero-Usuario no encontrada"));
        generoXUsuarioRepository.delete(generoXUsuario);
    }

    public void removeGeneroFromUsuario(Long usuarioId) {
        GeneroXUsuario generoXUsuario = generoXUsuarioRepository.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Relacion Genero-Usuario no encontrada"));
        generoXUsuarioRepository.delete(generoXUsuario);
    }
}