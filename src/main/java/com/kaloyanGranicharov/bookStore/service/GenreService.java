package com.kaloyanGranicharov.bookStore.service;

import com.kaloyanGranicharov.bookStore.exception.DataNotFoundException;
import com.kaloyanGranicharov.bookStore.model.Genre;
import com.kaloyanGranicharov.bookStore.repository.GenreRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GenreService {

    private final GenreRepository genreRepository;


    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre findByName(String name) {
        return genreRepository.findByName(name)
                .orElseThrow(() -> new DataNotFoundException(String.format("Genre with name %s does not exist", name)));
    }

    public Set<Genre> findAll() {
        List<Genre> genreList = genreRepository.findAll();
        Set<Genre> genres = genreList.stream().collect(Collectors.toSet());
        return genres;
    }

    public void save(@NonNull Genre genre) {
        genreRepository.save(genre);
    }

    public void deleteByName(@NonNull String name) {
        genreRepository.deleteByName(name);
    }
}

