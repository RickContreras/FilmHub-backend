package com.udea.filmhub.controller;

import com.udea.filmhub.dto.GeneroDTO;
import com.udea.filmhub.service.GeneroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
@CrossOrigin(origins = "*")
@Tag(name = "Genero", description = "API para gestionar géneros")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    @Operation(summary = "Obtener todos los géneros", description = "Devuelve una lista de todos los géneros")
    public ResponseEntity<List<GeneroDTO>> getAllGeneros() {
        List<GeneroDTO> generos = generoService.getAllGeneros();
        return ResponseEntity.ok(generos);
    }
}