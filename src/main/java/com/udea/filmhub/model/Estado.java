package com.udea.filmhub.model;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    // Relaciones
    @OneToMany(mappedBy = "estado")
    private Set<UsuarioXContenido> usuariosXContenido = new HashSet<>();

    public Estado() {
    }

    public Estado(String nombre) {
        this.nombre=nombre;
    }

    // Getters, setters, constructors...
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

    public Set<UsuarioXContenido> getUsuariosXContenido() {
        return usuariosXContenido;
    }

    public void setUsuariosXContenido(Set<UsuarioXContenido> usuariosXContenido) {
        this.usuariosXContenido = usuariosXContenido;
    }
}