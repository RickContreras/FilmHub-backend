package com.udea.filmhub.repository;

import com.udea.filmhub.model.GeneroXUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroXUsuarioRepository extends JpaRepository<GeneroXUsuario, Long> {
    List<GeneroXUsuario> findByUsuarioId(Long usuarioId);
}
