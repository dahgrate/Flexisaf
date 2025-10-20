package com.flexisaf.redaer.redaer_backend.service;

import com.flexisaf.redaer.redaer_backend.model.Genre;
import com.flexisaf.redaer.redaer_backend.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> listAll() {
        return genreRepository.findAll();
    }

    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }

    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre update(Long id, Genre updated) {
        return genreRepository.findById(id).map(g -> {
            g.setName(updated.getName());
            g.setDescription(updated.getDescription());
            return genreRepository.save(g);
        }).orElseThrow(() -> new RuntimeException("Genre not found with id " + id));
    }

    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}
