package com.udea.filmhub.controller;

import com.udea.filmhub.model.Contenido;
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
    public ResponseEntity<List<Contenido>> recomendarContenido(@PathVariable Long usuarioId) {
        List<Contenido> recomendaciones = recomendacionService.recomendarContenido(usuarioId);
        recomendacionService.guardarRecomendaciones(usuarioId, recomendaciones);
        return ResponseEntity.ok(recomendaciones);
    }
}