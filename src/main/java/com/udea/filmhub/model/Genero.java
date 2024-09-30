package com.udea.filmhub.model;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    // Relaciones
    @ManyToMany(mappedBy = "generos")
    private Set<Contenido> contenidos = new HashSet<>();

    public Genero() {
    }

    public Genero(String nombre) {
        this.nombre = nombre;
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

    public Set<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(Set<Contenido> contenidos) {
        this.contenidos = contenidos;
    }
}