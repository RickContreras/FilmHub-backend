package com.udea.filmhub.service;

import com.udea.filmhub.model.Genero;
import com.udea.filmhub.model.GeneroXUsuario;
import com.udea.filmhub.model.Usuario;
import com.udea.filmhub.repository.GeneroRepository;
import com.udea.filmhub.repository.GeneroXUsuarioRepository;
import com.udea.filmhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroXUsuarioService {

    @Autowired
    private GeneroXUsuarioRepository generoXUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private GeneroRepository generoRepository;

    public GeneroXUsuario addGeneroToUsuario(Long usuarioId, Long generoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Genero genero = generoRepository.findById(generoId)
                .orElseThrow(() -> new IllegalArgumentException("Genero no encontrado"));

        GeneroXUsuario generoXUsuario = new GeneroXUsuario(usuario, genero);
        return generoXUsuarioRepository.save(generoXUsuario);
    }

    public List<GeneroXUsuario> getGenerosByUsuario(Long usuarioId) {
        return generoXUsuarioRepository.findByUsuarioId(usuarioId);
    }
}