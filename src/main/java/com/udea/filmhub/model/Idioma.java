package com.udea.filmhub.model;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

@Entity
@Table(name = "idioma")
public class Idioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    // Relaciones
    @OneToMany(mappedBy = "idiomaOriginal")
    private Set<Contenido> contenidos = new HashSet<>();

    //Contructors
    public Idioma() {}
    public Idioma(String nombre) {
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
    //TODO: Implementar el método orElseThrow
    public Idioma orElseThrow(Supplier<? extends RuntimeException> exceptionSupplier) {
        if (this == null) {
            throw exceptionSupplier.get();
        }
        return this;
    }
}