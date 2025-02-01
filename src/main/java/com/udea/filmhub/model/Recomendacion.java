package com.udea.filmhub.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "recomendacion")
public class Recomendacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_recomendacion", nullable = false)
    private LocalDate fechaRecomendacion;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_contenido", nullable = false)
    private Contenido contenido;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;
    
    @PrePersist
    protected void onCreate() {
        this.fechaRecomendacion = LocalDate.now();
    }

    public Recomendacion() {
    }

    public Recomendacion(Usuario usuario, Contenido contenido, Estado estado) {
        this.usuario = usuario;
        this.contenido = contenido;
        this.estado = estado;
    }

    public Recomendacion(LocalDate fechaRecomendacion, Usuario usuario, Contenido contenido, Estado estado) {
        this.fechaRecomendacion = fechaRecomendacion;
        this.usuario = usuario;
        this.contenido = contenido;
        this.estado = estado;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaRecomendacion() {
        return fechaRecomendacion;
    }

    public void setFechaRecomendacion(LocalDate fechaRecomendacion) {
        this.fechaRecomendacion = fechaRecomendacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
