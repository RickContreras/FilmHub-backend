package com.udea.filmhub.dto;

import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Detalles de la solicitud para crear un contenido")
public class ContenidoDTO {
    @Schema(description = "ID del contenido", example = "1")
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Schema(description = "Título del contenido", example = "Inception")
    private String titulo;

    @Schema(description = "Año de lanzamiento del contenido", example = "2010-07-16")
    private LocalDate anioLanzamiento;

    @Schema(description = "URL del poster del contenido", example = "http://example.com/poster.jpg")
    private String poster;

    @NotBlank(message = "La sinopsis es obligatoria")
    @Size(max = 500, message = "La sinopsis no puede tener más de 500 caracteres")
    @Schema(description = "Sinopsis del contenido", example = "A mind-bending thriller...")
    private String sinopsis;

    @DecimalMin(value = "0.0", inclusive = false, message = "El rating debe ser mayor que 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "El rating debe ser menor o igual a 10")
    @Schema(description = "Rating de IMDb del contenido", example = "8.8")
    private Float imdbRating;

    @Min(value = 1, message = "El número total de episodios debe ser al menos 1")
    @Schema(description = "Número total de episodios", example = "10")
    private Integer numTotalEpisodios;

    @Min(value = 1, message = "El número total de temporadas debe ser al menos 1")
    @Schema(description = "Número total de temporadas", example = "1")
    private Integer numTotalTemporadas;

    @NotBlank(message = "La clasificación es obligatoria")
    @Schema(description = "Clasificación del contenido", example = "PG-13")
    private String clasificacion;

    @NotBlank(message = "El tipo de contenido es obligatorio")
    @Schema(description = "Tipo de contenido", example = "Movie")
    private String tipoContenido;

    @NotBlank(message = "El idioma original es obligatorio")
    @Schema(description = "Idioma original del contenido", example = "English")
    private String idiomaOriginal;

    // Getters y Setters
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

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }
}