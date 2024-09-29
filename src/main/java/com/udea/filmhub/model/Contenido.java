package com.udea.filmhub.model;
import jakarta.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
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
    private LocalDate anioLanzamiento;

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

    public LocalDate getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(LocalDate anioLanzamiento) {
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

    public Float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Float imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Integer getNumTotalEpisodios() {
        return numTotalEpisodios;
    }

    public void setNumTotalEpisodios(Integer numTotalEpisodios) {
        this.numTotalEpisodios = numTotalEpisodios;
    }

    public Integer getNumTotalTemporadas() {
        return numTotalTemporadas;
    }

    public void setNumTotalTemporadas(Integer numTotalTemporadas) {
        this.numTotalTemporadas = numTotalTemporadas;
    }

    public Time getDuracionPromedioEpisodio() {
        return duracionPromedioEpisodio;
    }

    public void setDuracionPromedioEpisodio(Time duracionPromedioEpisodio) {
        this.duracionPromedioEpisodio = duracionPromedioEpisodio;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public TipoContenido getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(TipoContenido tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public Idioma getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(Idioma idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public Set<UsuarioXContenido> getUsuariosXContenido() {
        return usuariosXContenido;
    }

    public void setUsuariosXContenido(Set<UsuarioXContenido> usuariosXContenido) {
        this.usuariosXContenido = usuariosXContenido;
    }

    public Set<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(Set<Genero> generos) {
        this.generos = generos;
    }
}