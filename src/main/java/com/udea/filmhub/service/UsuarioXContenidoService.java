package com.udea.filmhub.service;

import com.udea.filmhub.dto.UsuarioXContenidoRequestDTO;
import com.udea.filmhub.dto.UsuarioXContenidoResponseDTO;
import com.udea.filmhub.model.Contenido;
import com.udea.filmhub.model.Estado;
import com.udea.filmhub.model.Usuario;
import com.udea.filmhub.model.UsuarioXContenido;
import com.udea.filmhub.repository.ContenidoRepository;
import com.udea.filmhub.repository.EstadoRepository;
import com.udea.filmhub.repository.UsuarioRepository;
import com.udea.filmhub.repository.UsuarioXContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioXContenidoService {

    @Autowired
    private UsuarioXContenidoRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    // Obtener los contenidos asociados a un usuario
    public List<UsuarioXContenidoResponseDTO> getContenidosByUsuario(Long usuarioId) {
        List<UsuarioXContenido> relaciones = repository.findByUsuarioId(usuarioId);
        return relaciones.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    // Añadir un contenido a un usuario
    public UsuarioXContenidoResponseDTO addContenidoToUsuario(UsuarioXContenidoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Contenido contenido = contenidoRepository.findById(dto.getContenidoId())
                .orElseThrow(() -> new IllegalArgumentException("Contenido no encontrado"));

        Estado estado = estadoRepository.findById(dto.getEstadoId())
                .orElseThrow(() -> new IllegalArgumentException("Estado no encontrado"));

        UsuarioXContenido usuarioXContenido = new UsuarioXContenido();
        usuarioXContenido.setUsuario(usuario);
        usuarioXContenido.setContenido(contenido);
        usuarioXContenido.setEstado(estado);
        usuarioXContenido.setIsLiked(dto.getIsLiked());
        usuarioXContenido.setIsView(dto.getIsView());

        UsuarioXContenido savedEntity = repository.save(usuarioXContenido);
        return convertToResponseDTO(savedEntity);
    }

    // Eliminar la relación de contenido con usuario
    public void removeContenidoFromUsuario(Long id) {
        Optional<UsuarioXContenido> usuarioXContenido = repository.findById(id);
        usuarioXContenido.ifPresent(repository::delete);
    }

    // Convertir UsuarioXContenido a UsuarioXContenidoResponseDTO
    private UsuarioXContenidoResponseDTO convertToResponseDTO(UsuarioXContenido usuarioXContenido) {
        UsuarioXContenidoResponseDTO dto = new UsuarioXContenidoResponseDTO();
        dto.setId(usuarioXContenido.getId());
        dto.setUsuarioId(usuarioXContenido.getUsuario().getId());
        dto.setNombreUsuario(usuarioXContenido.getUsuario().getNombre());  // Asumiendo que la clase Usuario tiene un campo 'nombre'
        dto.setContenidoId(usuarioXContenido.getContenido().getId());
        dto.setNombreContenido(usuarioXContenido.getContenido().getTitulo());  // Asumiendo que la clase Contenido tiene un campo 'nombre'
        dto.setFechaAgregado(usuarioXContenido.getFechaAgregado());
        dto.setIsView(usuarioXContenido.getIsView());
        dto.setIsLiked(usuarioXContenido.getIsLiked());
        return dto;
    }
}