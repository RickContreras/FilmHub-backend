package com.udea.filmhub.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuario_x_contenido")
public class UsuarioXContenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_liked", nullable = false)
    private Boolean isLiked;

    @Column(name = "fecha_agregado", nullable = false, updatable = false)
    private LocalDate fechaAgregado;

    @Column(name = "is_view", nullable = false)
    private Boolean isView;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "id_contenido", nullable = false)
    private Contenido contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    // Inicialización de fecha en la que se agregó el contenido
    @PrePersist
    protected void onCreate() {
        this.fechaAgregado = LocalDate.now();
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Boolean isLiked) {
        this.isLiked = isLiked;
    }

    public LocalDate getFechaAgregado() {
        return fechaAgregado;
    }

    public Boolean getIsView() {
        return isView;
    }

    public void setIsView(Boolean isView) {
        this.isView = isView;
    }

    public Contenido getContenido() {
        return contenido;
    }

    public void setContenido(Contenido contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}