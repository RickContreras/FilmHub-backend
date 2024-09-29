package com.udea.filmhub.service;

import com.udea.filmhub.dto.ContenidoDTO;
import com.udea.filmhub.exceptions.ResourceNotFoundException;
import com.udea.filmhub.model.Contenido;
import com.udea.filmhub.repository.ClasificacionRepository;
import com.udea.filmhub.repository.ContenidoRepository;
import com.udea.filmhub.repository.TipoContenidoRepository;
import com.udea.filmhub.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private ClasificacionRepository clasificacionRepository;

    @Autowired
    private TipoContenidoRepository tipoContenidoRepository;

    @Autowired
    private IdiomaRepository idiomaRepository;

    public List<Contenido> getAllContenidos() {
        return contenidoRepository.findAll();
    }

    public Contenido getContenidoById(Long id) {
        return contenidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contenido no encontrado"));
    }

    public Contenido saveContenido(Contenido contenido) {
        try {
            return contenidoRepository.save(contenido);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el contenido", e);
        }
    }

    public void deleteContenido(Long id) {
        try {
            contenidoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el contenido", e);
        }
    }

    public ContenidoDTO convertToDTO(Contenido contenido) {
        ContenidoDTO dto = new ContenidoDTO();
        dto.setId(contenido.getId());
        dto.setTitulo(contenido.getTitulo());
        dto.setAnioLanzamiento(contenido.getAnioLanzamiento());
        dto.setPoster(contenido.getPoster());
        dto.setSinopsis(contenido.getSinopsis());
        dto.setImdbRating(contenido.getImdbRating());
        dto.setNumTotalEpisodios(contenido.getNumTotalEpisodios());
        dto.setNumTotalTemporadas(contenido.getNumTotalTemporadas());
        dto.setClasificacion(contenido.getClasificacion().getNombre());
        dto.setTipoContenido(contenido.getTipoContenido().getNombre());
        dto.setIdiomaOriginal(contenido.getIdiomaOriginal().getNombre());
        return dto;
    }

    public Contenido convertToEntity(ContenidoDTO contenidoDTO) {
        Contenido contenido = new Contenido();
        contenido.setTitulo(contenidoDTO.getTitulo());
        contenido.setAnioLanzamiento(contenidoDTO.getAnioLanzamiento());
        contenido.setPoster(contenidoDTO.getPoster());
        contenido.setSinopsis(contenidoDTO.getSinopsis());
        contenido.setImdbRating(contenidoDTO.getImdbRating());
        contenido.setNumTotalEpisodios(contenidoDTO.getNumTotalEpisodios());
        contenido.setNumTotalTemporadas(contenidoDTO.getNumTotalTemporadas());

        if (contenidoDTO.getClasificacion() != null) {
            contenido.setClasificacion(clasificacionRepository.findByNombre(contenidoDTO.getClasificacion())
                    .orElseThrow(() -> new ResourceNotFoundException("Clasificación no encontrada")));
        } else {
            throw new IllegalArgumentException("Clasificación no puede ser nula");
        }

        if (contenidoDTO.getTipoContenido() != null) {
            contenido.setTipoContenido(tipoContenidoRepository.findByNombre(contenidoDTO.getTipoContenido())
                    .orElseThrow(() -> new ResourceNotFoundException("Tipo de contenido no encontrado")));
        } else {
            throw new IllegalArgumentException("Tipo de contenido no puede ser nulo");
        }

        if (contenidoDTO.getIdiomaOriginal() != null) {
            contenido.setIdiomaOriginal(idiomaRepository.findByNombre(contenidoDTO.getIdiomaOriginal())
                    .orElseThrow(() -> new ResourceNotFoundException("Idioma original no encontrado")));
        } else {
            throw new IllegalArgumentException("Idioma original no puede ser nulo");
        }

        return contenido;
    }
}