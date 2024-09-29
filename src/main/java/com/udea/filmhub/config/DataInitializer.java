package com.udea.filmhub.config;

import com.udea.filmhub.model.Clasificacion;
import com.udea.filmhub.model.TipoContenido;
import com.udea.filmhub.model.Idioma;
import com.udea.filmhub.repository.ClasificacionRepository;
import com.udea.filmhub.repository.TipoContenidoRepository;
import com.udea.filmhub.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @Autowired
    private TipoContenidoRepository tipoContenidoRepository;

    @Autowired
    private IdiomaRepository idiomaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insertar datos de ejemplo en la tabla Clasificacion
        clasificacionRepository.save(new Clasificacion("PG-13", "Parents Strongly Cautioned"));
        clasificacionRepository.save(new Clasificacion("R", "Restricted"));
        clasificacionRepository.save(new Clasificacion("G", "General Audiences"));

        // Insertar datos de ejemplo en la tabla TipoContenido
        tipoContenidoRepository.save(new TipoContenido("Movie"));
        tipoContenidoRepository.save(new TipoContenido("Series"));
        tipoContenidoRepository.save(new TipoContenido("Documentary"));

        // Insertar datos de ejemplo en la tabla Idioma
        idiomaRepository.save(new Idioma("English"));
        idiomaRepository.save(new Idioma("Spanish"));
        idiomaRepository.save(new Idioma("French"));
    }
}