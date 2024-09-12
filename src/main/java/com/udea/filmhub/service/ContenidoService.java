package com.udea.filmhub.service;
import com.udea.filmhub.exceptions.ResourceNotFoundException;
import com.udea.filmhub.model.Contenido;
import com.udea.filmhub.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ContenidoService {
    @Autowired
    private ContenidoRepository contenidoRepository;
    public List<Contenido> getAllContenidos() {
        return contenidoRepository.findAll();
    }
    public Contenido getContenidoById(Long id) {
        return contenidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contenido no encontrado"));
    }
    // Otros métodos según sea necesario
}