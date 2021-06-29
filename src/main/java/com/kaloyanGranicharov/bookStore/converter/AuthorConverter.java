package com.kaloyanGranicharov.bookStore.converter;

import com.kaloyanGranicharov.bookStore.dto.AuthorDto;
import com.kaloyanGranicharov.bookStore.dto.BookDto;
import com.kaloyanGranicharov.bookStore.model.Author;
import com.kaloyanGranicharov.bookStore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorConverter {

    private final BookConverter bookConverter;

    @Autowired
    public AuthorConverter(BookConverter bookConverter) {
        this.bookConverter = bookConverter;
    }


    public Author convertToEntity(AuthorDto authorDto) {
        List<Book> books = new ArrayList<>();
        List<BookDto> bookDtos = authorDto.getBooks();

        for (BookDto bookDto : bookDtos) {
            Book book = bookConverter.convertToEntity(bookDto);
            books.add(book);
        }

        Author author = Author.builder()
                .id(authorDto.getId())
                .name(authorDto.getName())
                .books(books)
                .build();
        return author;
    }

    public AuthorDto convertToDto(Author author) {
        List<BookDto> bookDtos = new ArrayList<>();
        List<Book> books = author.getBooks();

        for (Book book : books) {
            BookDto bookDto = bookConverter.convertToDto(book);
            bookDtos.add(bookDto);
        }

        AuthorDto authorDto = AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .books(bookDtos)
                .build();

        return authorDto;
    }
}
