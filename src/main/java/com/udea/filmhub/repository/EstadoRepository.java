package com.udea.filmhub.repository;
import com.udea.filmhub.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}