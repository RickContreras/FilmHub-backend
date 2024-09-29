package com.udea.filmhub.model;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

@Entity
@Table(name = "clasificacion")
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    // Relaciones
    @OneToMany(mappedBy = "clasificacion")
    private Set<Contenido> contenidos = new HashSet<>();

    //Constructors
    public Clasificacion() {}
    public Clasificacion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters and setters
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(Set<Contenido> contenidos) {
        this.contenidos = contenidos;
    }
    public Clasificacion orElseThrow(Supplier<? extends RuntimeException> exceptionSupplier) {
        if (this == null) {
            throw exceptionSupplier.get();
        }
        return this;
    }
}