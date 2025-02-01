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
@RequestMapping("/UsuarioContenido")
@CrossOrigin(origins = "*")
@Tag(name = "UsuarioContenido", description = "Operaciones relacionadas con la relación Usuario-Contenido")
public class UsuarioXContenidoController {

    @Autowired
    private UsuarioXContenidoService service;


    //TODO: Este metodo deberia pertener a contenido para /contenido/usuario/{usuarioId}
    @Operation(summary = "Obtiene los contenidos asociados a un usuario")
    @GetMapping("/usuario/{usuarioId}")
    public List<UsuarioXContenidoResponseDTO> getContenidoByUsuario(@PathVariable Long usuarioId) {
        return service.getContenidosByUsuario(usuarioId);
    }

    @Operation(summary = "Añade la relacion de un contenido a un usuario de forma personalizada")
    @PostMapping
    public UsuarioXContenidoResponseDTO addContenidoToUsuario(@Valid @RequestBody UsuarioXContenidoRequestDTO dto) {
        return service.addContenidoToUsuario(dto);
    }

    
    @Operation(summary = "Elimina la relación numero id de acuerdo a como se haya guardado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeContenidoFromUsuario(@PathVariable Long id) {
        service.removeContenidoFromUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Añade una relación de contenido a usuario con valores predeterminados")
    @PostMapping("/{idUsuario}/{idContenido}")
    public UsuarioXContenidoResponseDTO addContenidoToUsuarioDefault(@PathVariable Long idUsuario, @PathVariable Long idContenido) {
        return service.addContenidoToUsuarioDefault(idUsuario, idContenido);
    }

    @Operation(summary = "Elimina la relación entre un usuario y un contenido")
    @DeleteMapping("/{idUsuario}/{idContenido}")
    public ResponseEntity<Void> removeContenidoFromUsuario(@PathVariable Long idUsuario, @PathVariable Long idContenido) {
        service.removeContenidoFromUsuario(idUsuario, idContenido);
        return ResponseEntity.noContent().build();
    }
}