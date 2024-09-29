package com.udea.filmhub.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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
    //Relaciones
    @OneToMany(mappedBy = "clasificacion")
    private Set<Contenido> contenidos = new HashSet<>();
    // Getters and setters
}
