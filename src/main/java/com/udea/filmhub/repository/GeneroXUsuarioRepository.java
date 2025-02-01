package com.udea.filmhub.repository;

import com.udea.filmhub.model.GeneroXUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneroXUsuarioRepository extends JpaRepository<GeneroXUsuario, Long> {
    Optional<GeneroXUsuario> findByUsuarioIdAndGeneroId(Long usuarioId, Long generoId);
    Optional<GeneroXUsuario> findByUsuarioId(Long usuarioId);
    Optional<GeneroXUsuario> findByUsuario_Id(Long usuarioId);
}
