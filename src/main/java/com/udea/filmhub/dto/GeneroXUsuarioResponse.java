package com.udea.filmhub.dto;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "Detalles de la respuesta de la relación Género-Usuario")
public class GeneroXUsuarioResponse {
    @Schema(description = "ID del usuario", example = "1")
    private Long usuarioId;
    @Schema(description = "Nombre del usuario", example = "Juan Perez")
    private String usuarioNombre;
    @Schema(description = "ID del género", example = "1")
    private Long generoId;
    @Schema(description = "Nombre del género", example = "Acción")
    private String generoNombre;

    public GeneroXUsuarioResponse(Long usuarioId, String usuarioNombre, Long generoId, String generoNombre) {
        this.usuarioId = usuarioId;
        this.usuarioNombre = usuarioNombre;
        this.generoId = generoId;
        this.generoNombre = generoNombre;
    }

    // Getters y setters
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public Long getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Long generoId) {
        this.generoId = generoId;
    }

    public String getGeneroNombre() {
        return generoNombre;
    }

    public void setGeneroNombre(String generoNombre) {
        this.generoNombre = generoNombre;
    }
}