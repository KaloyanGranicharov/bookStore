package com.kaloyanGranicharov.bookStore.service;

import com.kaloyanGranicharov.bookStore.exception.DataNotFoundException;
import com.kaloyanGranicharov.bookStore.model.Author;
import com.kaloyanGranicharov.bookStore.repository.AuthorRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author findByName(String name) {
        return authorRepository.findByName(name)
                .orElseThrow(() -> new DataNotFoundException(String.format("Author with name: %s does not exist.", name)));
    }

    public List<Author> findAll() {
        List<Author> authorsList = authorRepository.findAll();
        return authorsList;
    }


    public void save(@NonNull Author author) {
        Author wantedAuthor = authorRepository.findByName(author.getName())
                .orElseThrow(() -> new DataNotFoundException(String.format("Author with name %s does not exis.", author.getName())));

        authorRepository.save(wantedAuthor);
    }


    public void delete(@NonNull String name) {
        authorRepository.deleteByName(name);
    }
}
