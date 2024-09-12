package com.udea.filmhub.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Entity
@Table(name = "contenido")
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(name = "idclasificacion")
    private Integer idClasificacion;
    @Column(name = "idtipoaudiovisual")
    private Integer idTipoAudiovisual;
    @Column(name = "aniolanzamiento")
    private LocalDateTime anioLanzamiento;
    private String poster;
    private String sinopsis;
    @Column(name = "ididiomaoriginal")
    private Integer idIdiomaOriginal;
    @Column(name = "imdbrating")
    private Float imdbRating;

    // Relaciones

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer getIdClasificacion() {
        return idClasificacion;
    }
    public void setIdClasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }
    public Integer getIdTipoAudiovisual() {
        return idTipoAudiovisual;
    }
    public void setIdTipoAudiovisual(Integer idTipoAudiovisual) {
        this.idTipoAudiovisual = idTipoAudiovisual;
    }
    public LocalDateTime getAnioLanzamiento() {
        return anioLanzamiento;
    }
    public void setAnioLanzamiento(LocalDateTime anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }
    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public Integer getIdIdiomaOriginal() {
        return idIdiomaOriginal;
    }
    public void setIdIdiomaOriginal(Integer idIdiomaOriginal) {
        this.idIdiomaOriginal = idIdiomaOriginal;
    }
    public Float getImdbRating() {
        return imdbRating;
    }
    public void setImdbRating(Float imdbRating) {
        this.imdbRating = imdbRating;
    }
    //TODO: Implementar método findAll
    public List<Contenido> findAll() {
        return null;
    }
    //TODO: Implementar método findById
    public Optional<Object> findById(Long id) {
        return null;
    }
}