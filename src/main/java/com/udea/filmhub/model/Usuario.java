package com.udea.filmhub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede ser nulo o vacío")
    private String nombre;

    @Email(message = "El email debe tener un formato válido")
    @NotBlank(message = "El email no puede ser nulo o vacío")
    private String email;

    @NotBlank(message = "La contraseña no puede ser nula o vacía")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String contrasena;

    @NotBlank(message = "El avatar no puede ser nulo o vacío")
    private String avatar;

    @Column(name = "fecha_registro", updatable = false)
    private LocalDate fechaRegistro;

    // Relaciones
    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioXContenido> contenidos = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Recomendacion> recomendaciones = new HashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<GeneroXUsuario> generos = new HashSet<>();

    // Inicialización de fechaRegistro
    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDate.now();
    }

    // Constructores
    public Usuario() {}

    public Usuario(String nombre, String email, String contrasena, String avatar) {
        setNombre(nombre);
        setEmail(email);
        setContrasena(contrasena);
        setAvatar(avatar);
    }

    // Getters y Setters con validaciones
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            throw new IllegalArgumentException("El email no tiene un formato válido");
        }
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena == null || contrasena.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres");
        }
        // Aquí deberías aplicar un hash a la contraseña antes de almacenarla
        this.contrasena = contrasena;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        if (avatar == null || avatar.trim().isEmpty()) {
            throw new IllegalArgumentException("El avatar no puede ser nulo o vacío");
        }
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

    public Set<Recomendacion> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(Set<Recomendacion> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (this.id == null) {
            this.id = id;
        } else if (!this.id.equals(id)) {
            throw new IllegalArgumentException("No se puede cambiar el id de un usuario");
        }
    }

    public Set<GeneroXUsuario> getGeneros() {
        return generos;
    }

    public void setGeneros(Set<GeneroXUsuario> generos) {
        this.generos = generos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}