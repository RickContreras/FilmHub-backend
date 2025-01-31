package com.udea.filmhub.controller;

import com.udea.filmhub.model.Recomendacion;
import com.udea.filmhub.service.RecomendacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionController {

    @Autowired
    private RecomendacionService recomendacionService;

    @GetMapping
    public List<Recomendacion> getAllRecomendaciones() {
        return recomendacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recomendacion> getRecomendacionById(@PathVariable Long id) {
        Optional<Recomendacion> recomendacion = recomendacionService.findById(id);
        return recomendacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Recomendacion createRecomendacion(@RequestBody Recomendacion recomendacion) {
        return recomendacionService.save(recomendacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recomendacion> updateRecomendacion(@PathVariable Long id, @RequestBody Recomendacion recomendacionDetails) {
        Optional<Recomendacion> recomendacion = recomendacionService.findById(id);
        if (recomendacion.isPresent()) {
            Recomendacion updatedRecomendacion = recomendacion.get();
            updatedRecomendacion.setFechaRecomendacion(recomendacionDetails.getFechaRecomendacion());
            updatedRecomendacion.setUsuario(recomendacionDetails.getUsuario());
            updatedRecomendacion.setContenido(recomendacionDetails.getContenido());
            updatedRecomendacion.setEstado(recomendacionDetails.getEstado());
            return ResponseEntity.ok(recomendacionService.save(updatedRecomendacion));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecomendacion(@PathVariable Long id) {
        if (recomendacionService.findById(id).isPresent()) {
            recomendacionService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
