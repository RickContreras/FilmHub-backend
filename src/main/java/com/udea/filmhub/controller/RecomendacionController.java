package com.udea.filmhub.controller;

import com.udea.filmhub.dto.ContenidoDTO;
import com.udea.filmhub.service.RecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/recomendaciones")
@CrossOrigin(origins = "*")
@Tag(name = "Recomendacion", description = "API para gestionar recomendaciones de contenido")
public class RecomendacionController {

    @Autowired
    private RecomendacionService recomendacionService;

    
    @GetMapping("/usuario/{usuarioId}")
    @Operation(summary = "Obtener recomendaciones de contenido para un usuario", description = "Devuelve una lista de contenidos recomendados para un usuario")
    public ResponseEntity<List<ContenidoDTO>> recomendarContenido(@PathVariable Long usuarioId) {
        List<ContenidoDTO> recomendaciones = recomendacionService.recomendarContenido(usuarioId);
        return ResponseEntity.ok(recomendaciones);
    }
}