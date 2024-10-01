package com.udea.filmhub.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Detalles de la solicitud para crear una relación Usuario-Contenido")
public class UsuarioXContenidoRequestDTO {

    @NotNull
    @Schema(description = "ID del usuario", example = "1")
    private Long usuarioId;

    @NotNull
    @Schema(description = "ID del contenido", example = "1")
    private Long contenidoId;

    @NotNull
    @Schema(description = "ID del estado del contenido", example = "1")
    private Long estadoId;

    @Schema(description = "Indica si el contenido fue marcado como 'me gusta'", example = "true")
    private Boolean isLiked;

    @Schema(description = "Indica si el contenido fue visto", example = "true")
    private Boolean isView;

    // Getters y setters
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

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Boolean isLiked) {
        this.isLiked = isLiked;
    }

    public Boolean getIsView() {
        return isView;
    }

    public void setIsView(Boolean isView) {
        this.isView = isView;
    }
}