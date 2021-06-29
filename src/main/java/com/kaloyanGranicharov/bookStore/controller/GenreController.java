package com.kaloyanGranicharov.bookStore.controller;

import com.kaloyanGranicharov.bookStore.converter.GenreConverter;
import com.kaloyanGranicharov.bookStore.dto.GenreDto;
import com.kaloyanGranicharov.bookStore.model.Genre;
import com.kaloyanGranicharov.bookStore.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/genres")
public class GenreController {

    private final GenreService genreService;
    private final GenreConverter genreConverter;

    @Autowired
    public GenreController(GenreService genreService, GenreConverter genreConverter) {
        this.genreService = genreService;
        this.genreConverter = genreConverter;
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<GenreDto> findByName(@PathVariable String name) {
        Genre genre = genreService.findByName(name);
        GenreDto genreDto = genreConverter.convertToDto(genre);
        return ResponseEntity.ok(genreDto);
    }

    @GetMapping
    public ResponseEntity<Set<GenreDto>> findAll() {
        Set<Genre> genres = genreService.findAll();
        Set<GenreDto> genreDtos = new HashSet<>();

        for (Genre genre : genres) {
            GenreDto genreDto = genreConverter.convertToDto(genre);
            genreDtos.add(genreDto);
        }
        return ResponseEntity.ok(genreDtos);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody GenreDto genreDto) {
        genreService.save(genreConverter.convertToEntity(genreDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String name) {
        genreService.deleteByName(name);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}
