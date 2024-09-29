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

    // Getters, setters, constructors...
}
