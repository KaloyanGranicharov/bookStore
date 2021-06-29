package com.kaloyanGranicharov.bookStore.controller;

import com.kaloyanGranicharov.bookStore.converter.BookConverter;
import com.kaloyanGranicharov.bookStore.dto.BookDto;
import com.kaloyanGranicharov.bookStore.model.Book;
import com.kaloyanGranicharov.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookService bookService;
    private final BookConverter bookConverter;

    @Autowired
    public BookController(BookService bookService, BookConverter bookConverter) {
        this.bookService = bookService;
        this.bookConverter = bookConverter;
    }


    @GetMapping(value = "/{title}")
    public ResponseEntity<BookDto> findByTitle(@PathVariable String title) {
        Book book = bookService.findByTitle(title);
        BookDto bookDto = bookConverter.convertToDto(book);
        return ResponseEntity.ok(bookDto);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> findAllBooks() {
        List<Book> books = bookService.findAll();
        List<BookDto> bookDtos = new ArrayList<>();

        for (Book book : books) {
            BookDto bookDto = bookConverter.convertToDto(book);
            bookDtos.add(bookDto);
        }
        return ResponseEntity.ok(bookDtos);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> save(@RequestBody BookDto bookDto) {
        bookService.save(bookConverter.convertToEntity(bookDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(value = "/{title}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable String title) {
        bookService.delete(title);
        return ResponseEntity.ok().build();
    }

}
