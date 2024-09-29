package com.udea.filmhub.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    // Getters, setters, constructors...
}
