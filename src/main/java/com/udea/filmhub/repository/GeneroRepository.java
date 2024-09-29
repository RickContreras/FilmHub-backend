package com.udea.filmhub.repository;
import com.udea.filmhub.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}