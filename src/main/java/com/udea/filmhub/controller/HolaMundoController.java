package com.udea.filmhub.controller;
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