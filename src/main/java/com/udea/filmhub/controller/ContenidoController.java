package com.udea.filmhub.controller;

import com.udea.filmhub.dto.ContenidoDTO;
import com.udea.filmhub.model.Contenido;
import com.udea.filmhub.service.ContenidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contenidos")
@CrossOrigin(origins = "*")
@Tag(name = "Contenido", description = "API para gestionar contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    @Operation(summary = "Obtener todos los contenidos", description = "Devuelve una lista de todos los contenidos")
    public ResponseEntity<List<ContenidoDTO>> getAllContenidos() {
        List<Contenido> contenidos = contenidoService.getAllContenidos();
        List<ContenidoDTO> contenidoDTOs = contenidos.stream()
                .map(contenidoService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(contenidoDTOs);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener contenido por ID", description = "Devuelve un contenido específico por su ID")
    public ResponseEntity<ContenidoDTO> getContenidoById(@PathVariable Long id) {
        Contenido contenido = contenidoService.getContenidoById(id);
        ContenidoDTO contenidoDTO = contenidoService.convertToDTO(contenido);
        return ResponseEntity.ok(contenidoDTO);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo contenido", description = "Crea un nuevo contenido con los datos proporcionados")
    public ResponseEntity<ContenidoDTO> createContenido(@RequestBody ContenidoDTO contenidoDTO) {
        Contenido contenido = contenidoService.convertToEntity(contenidoDTO);
        Contenido nuevoContenido = contenidoService.saveContenido(contenido);
        ContenidoDTO nuevoContenidoDTO = contenidoService.convertToDTO(nuevoContenido);
        return ResponseEntity.ok(nuevoContenidoDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar contenido por ID", description = "Elimina un contenido específico por su ID")
    public ResponseEntity<Void> deleteContenido(@PathVariable Long id) {
        contenidoService.deleteContenido(id);
        return ResponseEntity.noContent().build();
    }
}