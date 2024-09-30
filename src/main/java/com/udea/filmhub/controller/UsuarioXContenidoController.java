package com.udea.filmhub.controller;

import com.udea.filmhub.dto.UsuarioXContenidoRequestDTO;
import com.udea.filmhub.dto.UsuarioXContenidoResponseDTO;
import com.udea.filmhub.service.UsuarioXContenidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contenido-usuario")
@Tag(name = "UsuarioXContenido", description = "Operaciones relacionadas con la relación Usuario-Contenido")
public class UsuarioXContenidoController {

    @Autowired
    private UsuarioXContenidoService service;

    @Operation(summary = "Obtiene los contenidos asociados a un usuario")
    @GetMapping("/usuario/{usuarioId}")
    public List<UsuarioXContenidoResponseDTO> getContenidoByUsuario(@PathVariable Long usuarioId) {
        return service.getContenidosByUsuario(usuarioId);
    }

    @Operation(summary = "Añade un contenido a un usuario")
    @PostMapping
    public UsuarioXContenidoResponseDTO addContenidoToUsuario(@Valid @RequestBody UsuarioXContenidoRequestDTO dto) {
        return service.addContenidoToUsuario(dto);
    }

    @Operation(summary = "Elimina la relación de un contenido con un usuario")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeContenidoFromUsuario(@PathVariable Long id) {
        service.removeContenidoFromUsuario(id);
        return ResponseEntity.noContent().build();
    }
}