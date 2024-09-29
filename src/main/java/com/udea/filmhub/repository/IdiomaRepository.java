package com.udea.filmhub.repository;
import com.udea.filmhub.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long> {
}