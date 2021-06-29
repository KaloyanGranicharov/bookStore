package com.kaloyanGranicharov.bookStore.converter;

import com.kaloyanGranicharov.bookStore.dto.GenreDto;
import com.kaloyanGranicharov.bookStore.model.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreConverter {

    public Genre convertToEntity(GenreDto genreDto) {
        Genre genre = Genre.builder()
                .id(genreDto.getId())
                .name(genreDto.getName())
                .build();
        return genre;
    }

    public GenreDto convertToDto(Genre genre) {
        GenreDto genreDto = GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
        return genreDto;
    }
}
