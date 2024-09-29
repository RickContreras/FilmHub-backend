package com.udea.filmhub.repository;
import com.udea.filmhub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findByNombre(String nombre);
    List<Usuario> findByFechaRegistro(LocalDate fechaRegistro);
}