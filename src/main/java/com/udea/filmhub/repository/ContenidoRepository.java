package com.udea.filmhub.repository;
import com.udea.filmhub.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
    List<Contenido> findByTitulo(String titulo);
    List<Contenido> findByGenerosNombre(String nombre);
    List<Contenido> findByClasificacionNombre(String nombre);
    List<Contenido> findByTipoContenidoNombre(String nombre);
    List<Contenido> findByIdiomaOriginalNombre(String nombre);
}