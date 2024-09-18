package com.udea.filmhub.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/saludar")
public class HolaMundoController {
    @GetMapping
    public String saludar() {
        return "Hola Mundo!";
    }
}