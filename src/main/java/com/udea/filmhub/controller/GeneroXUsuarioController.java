package com.udea.filmhub.controller;

import com.udea.filmhub.model.GeneroXUsuario;
import com.udea.filmhub.service.GeneroXUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos-usuario")
@CrossOrigin(origins = "*")
public class GeneroXUsuarioController {

    @Autowired
    private GeneroXUsuarioService generoXUsuarioService;

    @PostMapping("/{usuarioId}/{generoId}")
    public ResponseEntity<GeneroXUsuario> addGeneroToUsuario(@PathVariable Long usuarioId, @PathVariable Long generoId) {
        GeneroXUsuario generoXUsuario = generoXUsuarioService.addGeneroToUsuario(usuarioId, generoId);
        return ResponseEntity.ok(generoXUsuario);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<GeneroXUsuario>> getGenerosByUsuario(@PathVariable Long usuarioId) {
        List<GeneroXUsuario> generos = generoXUsuarioService.getGenerosByUsuario(usuarioId);
        return ResponseEntity.ok(generos);
    }
}
