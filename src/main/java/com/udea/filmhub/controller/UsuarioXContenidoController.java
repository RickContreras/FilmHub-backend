package com.udea.filmhub.controller;
import com.udea.filmhub.model.UsuarioXContenido;
import com.udea.filmhub.service.UsuarioXContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/usuarios/{usuarioId}/contenidos")
public class UsuarioXContenidoController {
    @Autowired
    private UsuarioXContenidoService usuarioXContenidoService;
    @GetMapping
    public ResponseEntity<Iterable<UsuarioXContenido>> getContenidosByUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(usuarioXContenidoService.getContenidosByUsuario(usuarioId));
    }
    @PostMapping("/{contenidoId}")
    public ResponseEntity<UsuarioXContenido> addContenidoToUsuario(
            @PathVariable Long usuarioId,
            @PathVariable Long contenidoId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioXContenidoService.addContenidoToUsuario(usuarioId, contenidoId));
    }

    // Otros endpoints según sea necesario
}