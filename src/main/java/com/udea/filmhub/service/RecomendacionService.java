package com.udea.filmhub.service;

import com.udea.filmhub.model.Recomendacion;
import com.udea.filmhub.repository.RecomendacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecomendacionService {

    @Autowired
    private RecomendacionRepository recomendacionRepository;

    public List<Recomendacion> findAll() {
        return recomendacionRepository.findAll();
    }

    public Optional<Recomendacion> findById(Long id) {
        return recomendacionRepository.findById(id);
    }

    public Recomendacion save(Recomendacion recomendacion) {
        return recomendacionRepository.save(recomendacion);
    }

    public void deleteById(Long id) {
        recomendacionRepository.deleteById(id);
    }
}
