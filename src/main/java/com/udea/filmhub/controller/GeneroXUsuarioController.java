package com.udea.filmhub.controller;

import com.udea.filmhub.dto.GeneroXUsuarioResponse;
import com.udea.filmhub.service.GeneroXUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/GeneroUsuario")
@CrossOrigin(origins = "*")
@Tag(name = "GeneroUsuario", description = "Operaciones relacionadas con la relación Genero-Usuario")
public class GeneroXUsuarioController {

    @Autowired
    private GeneroXUsuarioService generoXUsuarioService;

    @Operation(summary = "Añade o reemplaza un género para un usuario")
    @PostMapping("/usuario/{idUsuario}")
    public ResponseEntity<GeneroXUsuarioResponse> addOrReplaceGeneroForUsuario(@PathVariable Long idUsuario, @RequestBody String generoNombre) {
        GeneroXUsuarioResponse response = generoXUsuarioService.addOrReplaceGeneroForUsuario(idUsuario, generoNombre);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Añade o reemplaza un género para un usuario usando IDs")
    @PostMapping("/{idGenero}/{idUsuario}")
    public ResponseEntity<GeneroXUsuarioResponse> addOrReplaceGeneroForUsuario(@PathVariable Long idGenero, @PathVariable Long idUsuario) {
        GeneroXUsuarioResponse response = generoXUsuarioService.addOrReplaceGeneroForUsuario(idUsuario, idGenero);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Elimina un género de un usuario")
    @DeleteMapping("/{idGenero}/{idUsuario}")
    public ResponseEntity<Void> removeGeneroFromUsuario(@PathVariable Long idGenero, @PathVariable Long idUsuario) {
        generoXUsuarioService.removeGeneroFromUsuario(idUsuario, idGenero);
        return ResponseEntity.noContent().build();
    }
}