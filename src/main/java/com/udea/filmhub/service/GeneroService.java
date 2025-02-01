package com.udea.filmhub.service;

import com.udea.filmhub.dto.GeneroDTO;
import com.udea.filmhub.model.Genero;
import com.udea.filmhub.model.Usuario;
import com.udea.filmhub.model.GeneroXUsuario;
import com.udea.filmhub.repository.GeneroRepository;
import com.udea.filmhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udea.filmhub.repository.GeneroXUsuarioRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;
import com.udea.filmhub.exceptions.UsuarioNotFoundException;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private GeneroXUsuarioRepository generoXUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<GeneroDTO> getAllGeneros() {
        return generoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public GeneroDTO getGeneroByUsuario(Long idUsuario) {

        Usuario usuario=usuarioRepository.getUsuarioById(idUsuario);
        if(usuario==null){
            throw new UsuarioNotFoundException("Usuario no encontrado con id: " + idUsuario);
        }
        Optional<GeneroXUsuario> generoXUsuario = generoXUsuarioRepository.findByUsuario_Id(idUsuario);
        return generoXUsuario.map(gxu -> convertToDTO(gxu.getGenero())).orElse(null);
    }

    private GeneroDTO convertToDTO(Genero genero) {
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setId(genero.getId());
        generoDTO.setNombre(genero.getNombre());
        return generoDTO;
    }
}