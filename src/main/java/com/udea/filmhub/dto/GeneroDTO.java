package com.udea.filmhub.dto;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "Detalles del género")
public class GeneroDTO {
    
    //En general no deberia ir el id en el DTO, pero para efectos de este ejemplo lo dejaremos
    @Schema(description = "ID del género", example = "1")
    private Long id;
    @Schema(description = "Nombre del género", example = "Accion")
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