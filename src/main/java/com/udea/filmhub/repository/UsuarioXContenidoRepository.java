package com.udea.filmhub.repository;
import com.udea.filmhub.model.UsuarioXContenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface UsuarioXContenidoRepository extends JpaRepository<UsuarioXContenido, Long> {
    List<UsuarioXContenido> findByUsuarioId(Long usuarioId);
    Optional<UsuarioXContenido> findByUsuarioIdAndContenidoId(Long usuarioId, Long contenidoId);
    List<UsuarioXContenido> findByContenidoId(Long contenidoId);
    List<UsuarioXContenido> findByIsLiked(Boolean isLiked);
    List<UsuarioXContenido> findByIsView(Boolean isView);
    List<UsuarioXContenido> findByUsuarioIdAndIsLiked(Long usuarioId, boolean isLiked);
    List<UsuarioXContenido> findByUsuarioIdAndEstadoNombre(Long usuarioId, String estadoNombre);
    void deleteByUsuarioIdAndContenidoId(Long usuarioId, Long contenidoId);
}