package com.udea.filmhub.repository;
import com.udea.filmhub.model.Clasificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClasificacionRepository extends JpaRepository<Clasificacion, Long> {
}