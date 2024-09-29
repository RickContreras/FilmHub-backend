package com.udea.filmhub.repository;
import com.udea.filmhub.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
    // Metodo para encontrar los contenido asociados a un usuario
    @Query("SELECT uxc.contenido FROM UsuarioXContenido uxc WHERE uxc.usuario.id = :usuarioId")
    List<Contenido> findContenidosByUsuarioId(@Param("usuarioId") Long usuarioId);
    List<Contenido> findByTitulo(String titulo);
    List<Contenido> findByGenerosNombre(String nombre);
    List<Contenido> findByClasificacionNombre(String nombre);
    List<Contenido> findByTipoContenidoNombre(String nombre);
    List<Contenido> findByIdiomaOriginalNombre(String nombre);
}