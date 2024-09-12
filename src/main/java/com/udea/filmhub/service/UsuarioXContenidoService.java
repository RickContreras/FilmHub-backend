package com.udea.filmhub.service;
import com.udea.filmhub.model.UsuarioXContenido;
import com.udea.filmhub.repository.UsuarioXContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UsuarioXContenidoService {
    @Autowired
    private UsuarioXContenidoRepository usuarioXContenidoRepository;
    //Todo: Implementar lógica para agregar contenido a un usuario
    public UsuarioXContenido addContenidoToUsuario(Long usuarioId, Long contenidoId) {
        // Lógica para agregar contenido a un usuario
        // Incluir validaciones necesarias
        return null;
    }
    //Todo: Implementar lógica para obtener solo los contenidos de un usuario, sin incluir al usuario
    public Iterable<UsuarioXContenido> getContenidosByUsuario(Long usuarioId) {
        return usuarioXContenidoRepository.findByUsuarioId(usuarioId);
    }
    // Otros métodos según sea necesario
}