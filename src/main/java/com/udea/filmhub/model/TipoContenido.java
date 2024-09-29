package com.udea.filmhub.model;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

@Entity
@Table(name = "tipo_contenido")
public class TipoContenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    // Relaciones
    @OneToMany(mappedBy = "tipoContenido")
    private Set<Contenido> contenidos = new HashSet<>();

    //Constructors
    public TipoContenido() {}

    public TipoContenido(String nombre) {
        this.nombre = nombre;
    }

    // Getters, setters, constructors...
    public Set<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(Set<Contenido> contenidos) {
        this.contenidos = contenidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //Todo: Implementar el método orElseThrow
    public TipoContenido orElseThrow(Supplier<? extends RuntimeException> exceptionSupplier) {
        if (this == null) {
            throw exceptionSupplier.get();
        }
        return this;
    }
}