package com.udea.filmhub.repository;
import com.udea.filmhub.model.UsuarioXContenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface UsuarioXContenidoRepository extends JpaRepository<UsuarioXContenido, Long> {
    // Obtiene el usuario y contenidos asocidados a un usuario específico
    List<UsuarioXContenido> findByUsuarioId(Long usuarioId);
    // Para obtener una relacion específica entre un usuario y un contenido
    Optional<UsuarioXContenido> findByUsuarioIdAndContenidoId(Long usuarioId, Long contenidoId);
    List<UsuarioXContenido> findByContenidoId(Long contenidoId);
    List<UsuarioXContenido> findByIsLiked(Boolean isLiked);
    List<UsuarioXContenido> findByIsView(Boolean isView);

    // Metodo para encontrar los contenido asociados a un usuario
    // @Query("SELECT uxc.contenido FROM UsuarioXContenido uxc WHERE uxc.usuario.id = :usuarioId")
    // List<Contenido> findContenidosByUsuarioId(@Param("usuarioId") Long usuarioId);
}