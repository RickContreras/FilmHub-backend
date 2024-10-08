package com.udea.filmhub.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;
    private String avatar;

    @Column(name = "fecha_registro",updatable = false)
    private LocalDate fechaRegistro;

    // Relaciones
    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioXContenido> contenidos = new HashSet<>();

    // Inicialización de fechaRegistro
    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDate.now();
    }

    // Getters and Setters
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Set<UsuarioXContenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(Set<UsuarioXContenido> contenidos) {
        this.contenidos = contenidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}