package com.udea.filmhub.service;

import com.udea.filmhub.model.Contenido;
import com.udea.filmhub.model.Estado;
import com.udea.filmhub.model.Recomendacion;
import com.udea.filmhub.model.Usuario;
import com.udea.filmhub.model.UsuarioXContenido;
import com.udea.filmhub.repository.ContenidoRepository;
import com.udea.filmhub.repository.EstadoRepository;
import com.udea.filmhub.repository.RecomendacionRepository;
import com.udea.filmhub.repository.UsuarioRepository;
import com.udea.filmhub.repository.UsuarioXContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecomendacionService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private UsuarioXContenidoRepository usuarioXContenidoRepository;

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Contenido> recomendarContenido(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Set<UsuarioXContenido> contenidosUsuario = usuario.getContenidos();

        if (contenidosUsuario.isEmpty()) {
            // Recomendar contenido basado en los géneros del usuario
            Set<String> generosUsuario = usuario.getGeneros().stream()
                    .map(generoXUsuario -> generoXUsuario.getGenero().getNombre())
                    .collect(Collectors.toSet());

            return contenidoRepository.findByGenerosNombreIn(generosUsuario).stream()
                    .limit(5)
                    .collect(Collectors.toList());
        } else {
            // Usar el algoritmo KDA para recomendar contenido similar
            return recomendarContenidoKDA(contenidosUsuario);
        }
    }

    private List<Contenido> recomendarContenidoKDA(Set<UsuarioXContenido> contenidosUsuario) {
        // Implementa el algoritmo KDA aquí
        // Por simplicidad, vamos a devolver los primeros 5 contenidos
        return contenidoRepository.findAll().stream()
                .limit(5)
                .collect(Collectors.toList());
    }

    public void guardarRecomendaciones(Long usuarioId, List<Contenido> contenidos) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Estado estado = estadoRepository.findByNombre("Agregado")
                .orElseThrow(() -> new IllegalArgumentException("Estado 'Agregado' no encontrado"));

        List<Recomendacion> recomendaciones = contenidos.stream()
                .map(contenido -> new Recomendacion(usuario, contenido, estado))
                .collect(Collectors.toList());

        recomendacionRepository.saveAll(recomendaciones);
    }
}