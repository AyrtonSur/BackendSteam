package com.devweb.backendsteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.backendsteam.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    
}
