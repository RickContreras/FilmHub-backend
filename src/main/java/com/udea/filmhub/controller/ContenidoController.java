package com.udea.filmhub.controller;
import com.udea.filmhub.model.Contenido;
import com.udea.filmhub.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/contenidos")
public class ContenidoController {
    @Autowired
    private ContenidoService contenidoService;
    @GetMapping
    public ResponseEntity<List<Contenido>> getAllContenidos() {
        return ResponseEntity.ok(contenidoService.getAllContenidos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Contenido> getContenidoById(@PathVariable Long id) {
        return ResponseEntity.ok(contenidoService.getContenidoById(id));
    }
    // Otros endpoints según sea necesario
}