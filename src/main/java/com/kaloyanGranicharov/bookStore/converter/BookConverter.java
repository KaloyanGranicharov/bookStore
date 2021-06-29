package com.kaloyanGranicharov.bookStore.converter;

import com.kaloyanGranicharov.bookStore.dto.BookDto;
import com.kaloyanGranicharov.bookStore.model.Author;
import com.kaloyanGranicharov.bookStore.model.Book;
import com.kaloyanGranicharov.bookStore.model.Genre;
import com.kaloyanGranicharov.bookStore.service.AuthorService;
import com.kaloyanGranicharov.bookStore.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {


    private final AuthorService authorService;
    private final GenreService genreService;

    @Autowired
    public BookConverter(AuthorService authorService, GenreService genreService) {
        this.authorService = authorService;
        this.genreService = genreService;
    }


    public Book convertToEntity(BookDto bookDto) {
        Author author = authorService.findByName(bookDto.getAuthor());
        Genre genre = genreService.findByName(bookDto.getGenre());

        Book book = Book.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .genre(genre)
                .author(author)
                .build();
        return book;
    }

    public BookDto convertToDto(Book book) {

        BookDto bookDto = BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .genre(book.getGenre().getName())
                .author(book.getAuthor().getName())
                .build();
        return bookDto;
    }


}
