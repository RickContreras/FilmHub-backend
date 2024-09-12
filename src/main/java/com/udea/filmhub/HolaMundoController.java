package com.udea.filmhub;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HolaMundoController {
    @RequestMapping("/hola")
    public String saludar() {
        return "Hola Mundo!";
    }
}

// Que commit podria poner con estos cambios? Sigue las mejores practicas de git
// git commit -m "Añadido controlador HolaMundoController con un endpoint /saludar/hola que retorna 'Hola Mundo!'"

