package com.udea.filmhub.dto;

public class GeneroXUsuarioResponse {
    private Long usuarioId;
    private String usuarioNombre;
    private Long generoId;
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