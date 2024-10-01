package com.udea.filmhub.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Detalles de la solicitud para crear un Usuario")
public class UsuarioDTO {

    @Schema(description = "ID del usuario", example = "1")
    private Long id;

    @Schema(description = "Nombre del usuario", example = "Juan Perez")
    private String nombre;

    @Schema(description = "Email del usuario", example = "juan.perez@example.com")
    private String email;

    @Schema(description = "Avatar del usuario", example = "avatar.png")
    private String avatar;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}