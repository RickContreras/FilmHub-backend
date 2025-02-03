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
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @Autowired
    private TipoContenidoRepository tipoContenidoRepository;

    @Autowired
    private IdiomaRepository idiomaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private UsuarioXContenidoRepository usuarioXContenidoRepository;

    @Autowired
    private GeneroXUsuarioRepository generoXUsuarioRepository;


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
        Genero accion = generoRepository.save(new Genero("Accion"));
        Genero comedia = generoRepository.save(new Genero("Comedia"));
        Genero drama = generoRepository.save(new Genero("Drama"));
        generoRepository.save(new Genero("Ciencia Ficcion"));
        generoRepository.save(new Genero("Terror"));
        generoRepository.save(new Genero("Romance"));
        generoRepository.save(new Genero("Aventura"));
        generoRepository.save(new Genero("Fantasia"));
        generoRepository.save(new Genero("Misterio"));
        generoRepository.save(new Genero("Documental"));

        // Insertar datos de ejemplo en la tabla Estado
        Estado visto = estadoRepository.save(new Estado("Visto"));
        Estado eliminado = estadoRepository.save(new Estado("Eliminado"));
        Estado agregado = estadoRepository.save(new Estado("Agregado"));
        Estado recomendado = estadoRepository.save(new Estado("Recomendado"));
        estadoRepository.save(new Estado("Favorito"));

        // Insertar datos de ejemplo en la tabla Usuario
        Usuario usuario = usuarioRepository.save(new Usuario("Juan Perez", "juan.perez@example.com", "password", "avatar.png"));
        
        // Insertar datos de ejemplo en la tabla GeneroXUsuario
        GeneroXUsuario generoXUsuario1 = new GeneroXUsuario(usuario, accion);
        generoXUsuarioRepository.save(generoXUsuario1);

        // Leer contenidos desde el archivo JSON
        // Register the JavaTimeModule
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        InputStream inputStream = new ClassPathResource("contenidos.json").getInputStream();
        List<Contenido> contenidos = mapper.readValue(inputStream, new TypeReference<List<Contenido>>() {});

        // Guardar contenidos en la base de datos
        for (Contenido contenido : contenidos) {
            
            List<Genero> generos = generoRepository.findAll();
            if (!generos.isEmpty()) {
                Genero generoAleatorio = generos.get((int) (Math.random() * generos.size()));
                contenido.getGeneros().add(generoAleatorio);
            }
        
            contenido.setClasificacion(pg13); // Asignar una clasificación por defecto
            contenido.setTipoContenido(movie); // Asignar un tipo de contenido por defecto
            contenido.setIdiomaOriginal(english); // Asignar un idioma por defecto
            contenido.setNumTotalEpisodios(1); // Asignar un número total de episodios por defecto
            contenido.setNumTotalTemporadas(1); // Asignar un número total de temporadas por defecto
            contenidoRepository.save(contenido);
        }
    }
}