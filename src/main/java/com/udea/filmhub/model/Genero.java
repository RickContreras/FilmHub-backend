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

    //Relaciones

    @ManyToMany(mappedBy = "generos")
    private Set<Contenido> contenidos = new HashSet<>();

    // Getters, setters, constructors...
}
