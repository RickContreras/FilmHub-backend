package com.udea.filmhub.service;

import com.udea.filmhub.dto.ContenidoDTO;
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
import java.util.Map;
import java.util.HashMap;

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

    public List<ContenidoDTO> recomendarContenido(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Set<UsuarioXContenido> contenidosUsuario = usuario.getContenidos();

        List<Contenido> contenidos;
        if (contenidosUsuario.isEmpty()) {
            // Recomendar contenido basado en los géneros del usuario
            Set<String> generosUsuario = usuario.getGeneros().stream()
                    .map(generoXUsuario -> generoXUsuario.getGenero().getNombre())
                    .collect(Collectors.toSet());

            contenidos = contenidoRepository.findByGenerosNombreIn(generosUsuario).stream()
                    .limit(5)
                    .collect(Collectors.toList());
        } else {
            // Usar el algoritmo KDA para recomendar contenido similar
            contenidos = recomendarContenidoKDA(contenidosUsuario);
        }

        return contenidos.stream()
                .map(contenido -> new ContenidoDTO(
                        contenido.getId(),
                        contenido.getTitulo(),
                        contenido.getAnioLanzamiento(),
                        contenido.getPoster(),
                        contenido.getSinopsis()
                ))
                .collect(Collectors.toList());
    }

    //Para otras implementaciones se podria usar las siguientes bibliotecas: Apache Commons Math, Smile, Weka, etc.

    private List<Contenido> recomendarContenidoKDA(Set<UsuarioXContenido> contenidosUsuario) {
        List<Contenido> todosLosContenidos = contenidoRepository.findAll();
        List<Contenido> contenidosUsuarioList = contenidosUsuario.stream()
                .map(UsuarioXContenido::getContenido)
                .collect(Collectors.toList());

        Map<Contenido, Double> similitudes = new HashMap<>();

        for (Contenido contenido : todosLosContenidos) {
            if (!contenidosUsuarioList.contains(contenido)) {
                double similitud = calcularSimilitud(contenidosUsuarioList, contenido);
                similitudes.put(contenido, similitud);
            }
        }

        return similitudes.entrySet().stream()
                .sorted(Map.Entry.<Contenido, Double>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private double calcularSimilitud(List<Contenido> contenidosUsuario, Contenido contenido) {
        // Implementa la lógica para calcular la similitud entre los contenidos
        // Aquí puedes usar la distancia coseno, euclidiana, etc.
        // Este es un ejemplo básico usando la distancia coseno
        double similitud = 0.0;
        for (Contenido c : contenidosUsuario) {
            similitud += calcularDistanciaCoseno(c, contenido);
        }
        return similitud / contenidosUsuario.size();
    }

    private double calcularDistanciaCoseno(Contenido c1, Contenido c2) {
        // Implementa la lógica para calcular la distancia coseno entre dos contenidos
        // Este es un ejemplo básico
        double dotProduct = c1.getTitulo().length() * c2.getTitulo().length(); // Ejemplo simple
        double magnitude1 = Math.sqrt(c1.getTitulo().length());
        double magnitude2 = Math.sqrt(c2.getTitulo().length());
        return dotProduct / (magnitude1 * magnitude2);
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