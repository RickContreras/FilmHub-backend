package com.udea.filmhub.controller;

import com.udea.filmhub.dto.ContenidoDTO;
import com.udea.filmhub.service.RecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recomendaciones")
@CrossOrigin(origins = "*")
public class RecomendacionController {

    @Autowired
    private RecomendacionService recomendacionService;

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ContenidoDTO>> recomendarContenido(@PathVariable Long usuarioId) {
        List<ContenidoDTO> recomendaciones = recomendacionService.recomendarContenido(usuarioId);
        return ResponseEntity.ok(recomendaciones);
    }
}