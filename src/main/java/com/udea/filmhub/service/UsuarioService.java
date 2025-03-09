package com.udea.filmhub.service;

import com.udea.filmhub.dto.UsuarioDTO;
import com.udea.filmhub.exceptions.UsuarioNotFoundException;
import com.udea.filmhub.exceptions.ValidationException;
import com.udea.filmhub.model.Usuario;
import com.udea.filmhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        validateUsuario(usuarioDTO);
        Usuario usuario = convertToEntity(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return convertToDTO(savedUsuario);
    }

    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO getUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));
        return convertToDTO(usuario);
    }

    public void deleteUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNotFoundException("Usuario no encontrado con id: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO getUsuarioByCorreo(String correo) {
        Usuario usuario = usuarioRepository.findByEmail(correo)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con correo: " + correo));
        return convertToDTO(usuario);
    }

    private void validateUsuario(UsuarioDTO usuarioDTO) {
        Map<String, String> errors = new HashMap<>();

        if (!EMAIL_PATTERN.matcher(usuarioDTO.getEmail()).matches()) {
            errors.put("email", "The email field must be a valid email");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setAvatar(usuario.getAvatar());
        return usuarioDTO;
    }

    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setAvatar(usuarioDTO.getAvatar());
        return usuario;
    }
}