package com.udea.filmhub.dto;

public class GeneroDTO {
    
    //En general no deberia ir el id en el DTO, pero para efectos de este ejemplo lo dejaremos
    private Long id;
    private String nombre;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}