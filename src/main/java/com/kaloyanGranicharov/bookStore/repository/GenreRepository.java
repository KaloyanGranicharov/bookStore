package com.kaloyanGranicharov.bookStore.repository;

import com.kaloyanGranicharov.bookStore.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    Optional<Genre> findByName(String name);

    void deleteByName(String name);

}
