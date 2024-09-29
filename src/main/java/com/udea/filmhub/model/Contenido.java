package com.udea.filmhub.model;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contenido")
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(name = "anio_lanzamiento")
    private LocalDateTime anioLanzamiento;

    private String poster;
    private String sinopsis;

    @Column(name = "imdb_rating")
    private Float imdbRating;

    @Column(name = "num_total_episodios")
    private Integer numTotalEpisodios;

    @Column(name = "num_total_temporadas")
    private Integer numTotalTemporadas;

    @Column(name = "duracion_promedio_episodio")
    private Time duracionPromedioEpisodio;

    // Relaciones

    @ManyToOne
    @JoinColumn(name = "id_clasificacion", nullable = false)
    private Clasificacion clasificacion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contenido", nullable = false)
    private TipoContenido tipoContenido;

    @ManyToOne
    @JoinColumn(name = "id_idioma_original", nullable = false)
    private Idioma idiomaOriginal;

    @OneToMany(mappedBy = "contenido")
    private Set<UsuarioXContenido> usuariosXContenido = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "genero_x_contenido",
            joinColumns = @JoinColumn(name = "id_contenido"),
            inverseJoinColumns = @JoinColumn(name = "id_genero")
    )
    private Set<Genero> generos = new HashSet<>();

    // Getters and Setters
}