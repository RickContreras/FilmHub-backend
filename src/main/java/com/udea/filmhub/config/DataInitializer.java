package com.udea.filmhub.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.filmhub.model.*;
import com.udea.filmhub.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.InputStream;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @Autowired
    private TipoContenidoRepository tipoContenidoRepository;

    @Autowired
    private IdiomaRepository idiomaRepository;

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void run(String... args) throws Exception {


        // Insertar datos de ejemplo en la tabla Clasificacion
        Clasificacion pg13 = clasificacionRepository.save(new Clasificacion("PG-13", "Parents Strongly Cautioned"));
        Clasificacion r = clasificacionRepository.save(new Clasificacion("R", "Restricted"));
        Clasificacion g = clasificacionRepository.save(new Clasificacion("G", "General Audiences"));

        // Insertar datos de ejemplo en la tabla TipoContenido
        TipoContenido movie = tipoContenidoRepository.save(new TipoContenido("Movie"));
        TipoContenido series = tipoContenidoRepository.save(new TipoContenido("Series"));
        TipoContenido documentary = tipoContenidoRepository.save(new TipoContenido("Documentary"));

        // Insertar datos de ejemplo en la tabla Idioma
        Idioma english = idiomaRepository.save(new Idioma("English"));
        Idioma spanish = idiomaRepository.save(new Idioma("Spanish"));
        Idioma french = idiomaRepository.save(new Idioma("French"));

        // Insertar datos de ejemplo en la tabla Genero
        generoRepository.save(new Genero("Accion"));
        generoRepository.save(new Genero("Comedia"));
        generoRepository.save(new Genero("Drama"));
        generoRepository.save(new Genero("Ciencia Ficcion"));
        generoRepository.save(new Genero("Terror"));
        generoRepository.save(new Genero("Romance"));
        generoRepository.save(new Genero("Aventura"));
        generoRepository.save(new Genero("Fantasia"));
        generoRepository.save(new Genero("Misterio"));
        generoRepository.save(new Genero("Documental"));

        // Insertar datos de ejemplo en la tabla Estado
        estadoRepository.save(new Estado("Visto"));
        estadoRepository.save(new Estado("Eliminado"));
        estadoRepository.save(new Estado("Agregado"));
        estadoRepository.save(new Estado("Favorito"));
        estadoRepository.save(new Estado("Recomendado"));



        // Leer contenidos desde el archivo JSON
        // Register the JavaTimeModule
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        InputStream inputStream = new ClassPathResource("contenidos.json").getInputStream();
        List<Contenido> contenidos = mapper.readValue(inputStream, new TypeReference<List<Contenido>>() {});

        // Guardar contenidos en la base de datos
        for (Contenido contenido : contenidos) {
            contenido.setClasificacion(pg13); // Asignar una clasificación por defecto
            contenido.setTipoContenido(movie); // Asignar un tipo de contenido por defecto
            contenido.setIdiomaOriginal(english); // Asignar un idioma por defecto
            contenidoRepository.save(contenido);
        }
    }
}