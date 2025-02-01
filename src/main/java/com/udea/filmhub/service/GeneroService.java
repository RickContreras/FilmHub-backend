package com.udea.filmhub.service;

import com.udea.filmhub.dto.GeneroDTO;
import com.udea.filmhub.model.Genero;
import com.udea.filmhub.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<GeneroDTO> getAllGeneros() {
        return generoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private GeneroDTO convertToDTO(Genero genero) {
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setId(genero.getId());
        generoDTO.setNombre(genero.getNombre());
        return generoDTO;
    }
}