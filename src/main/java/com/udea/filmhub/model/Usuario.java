package com.udea.filmhub.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id // Indica que es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que es autoincremental
    private Long id; //Se recomienda usar Integer en vez de int
    // Si se cambia el nombre de una variable, se debe usar @Column(name = "nombre")
    private String nombre;
    private String email;
    private String contrasena;
    private String avatar;
    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    // Relaciones

    // Getters and Setters
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
}