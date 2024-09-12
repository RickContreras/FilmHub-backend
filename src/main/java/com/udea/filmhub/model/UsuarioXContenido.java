package com.udea.filmhub.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "usuarioxcontenido")
public class UsuarioXContenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idcontenido")
    private Contenido contenido;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @Column(name = "isliked")
    private Boolean isLiked;
    @Column(name = "fechaagregado")
    private LocalDate fechaAgregado;
    @Column(name = "idestado")
    private Integer idEstado;
    @Column(name = "isvisto")
    private Boolean isView;

    // Getters, setters, constructors

    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}
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
    public Boolean getLiked() {
        return isLiked;
    }
    public void setLiked(Boolean liked) {
        isLiked = liked;
    }
    public LocalDate getFechaAgregado() {
        return fechaAgregado;
    }
    public void setFechaAgregado(LocalDate fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }
    public Integer getIdEstado() {
        return idEstado;
    }
    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }
    public Boolean getView() {
        return isView;
    }
    public void setView(Boolean view) {
        isView = view;
    }
}
