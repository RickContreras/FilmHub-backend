package com.udea.filmhub.controller;

import com.udea.filmhub.dto.GeneroXUsuarioResponse;
import com.udea.filmhub.service.GeneroXUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/GeneroUsuario")
@CrossOrigin(origins = "*")
public class GeneroXUsuarioController {

    @Autowired
    private GeneroXUsuarioService generoXUsuarioService;

    @PostMapping("/usuario/{idUsuario}")
    public ResponseEntity<GeneroXUsuarioResponse> addOrReplaceGeneroForUsuario(@PathVariable Long idUsuario, @RequestBody String generoNombre) {
        GeneroXUsuarioResponse response = generoXUsuarioService.addOrReplaceGeneroForUsuario(idUsuario, generoNombre);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{idGenero}/{idUsuario}")
    public ResponseEntity<GeneroXUsuarioResponse> addOrReplaceGeneroForUsuario(@PathVariable Long idGenero, @PathVariable Long idUsuario) {
        GeneroXUsuarioResponse response = generoXUsuarioService.addOrReplaceGeneroForUsuario(idUsuario, idGenero);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{idGenero}/{idUsuario}")
    public ResponseEntity<Void> removeGeneroFromUsuario(@PathVariable Long idGenero, @PathVariable Long idUsuario) {
        generoXUsuarioService.removeGeneroFromUsuario(idUsuario, idGenero);
        return ResponseEntity.noContent().build();
    }
}