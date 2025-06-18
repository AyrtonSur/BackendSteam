package com.devweb.backendsteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.backendsteam.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    
}
