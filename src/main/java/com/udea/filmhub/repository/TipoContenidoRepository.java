package com.udea.filmhub.repository;
import com.udea.filmhub.model.TipoContenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TipoContenidoRepository extends JpaRepository<TipoContenido, Long> {
    TipoContenido findByNombre(String tipoContenido);
}