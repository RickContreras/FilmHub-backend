package com.udea.filmhub.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(description = "Detalles de la respuesta de la relación Usuario-Contenido")
public class UsuarioXContenidoResponseDTO {

    @Schema(description = "ID de la relación Usuario-Contenido", example = "1")
    private Long id;

    @Schema(description = "ID del usuario", example = "1")
    private Long usuarioId;

    @Schema(description = "ID del contenido", example = "1")
    private Long contenidoId;

    @Schema(description = "Nombre del contenido", example = "Pelicula A")
    private String nombreContenido;

    @Schema(description = "Nombre del usuario", example = "Juan Perez")
    private String nombreUsuario;

    @Schema(description = "Fecha en la que se agregó el contenido", example = "2024-09-01")
    private LocalDate fechaAgregado;

    @Schema(description = "Indica si el contenido fue visto", example = "true")
    private Boolean isView;

    @Schema(description = "Indica si el contenido fue marcado como 'me gusta'", example = "true")
    private Boolean isLiked;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getContenidoId() {
        return contenidoId;
    }

    public void setContenidoId(Long contenidoId) {
        this.contenidoId = contenidoId;
    }

    public String getNombreContenido() {
        return nombreContenido;
    }

    public void setNombreContenido(String nombreContenido) {
        this.nombreContenido = nombreContenido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public LocalDate getFechaAgregado() {
        return fechaAgregado;
    }

    public void setFechaAgregado(LocalDate fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

    public Boolean getIsView() {
        return isView;
    }

    public void setIsView(Boolean isView) {
        this.isView = isView;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Boolean isLiked) {
        this.isLiked = isLiked;
    }
}

