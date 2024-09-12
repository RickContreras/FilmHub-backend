package com.udea.filmhub.repository;
import com.udea.filmhub.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
    // Métodos personalizados si son necesarios
    List<Contenido> findByTitulo(String titulo);
}