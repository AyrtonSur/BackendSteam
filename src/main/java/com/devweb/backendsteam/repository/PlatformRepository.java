package com.devweb.backendsteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.backendsteam.model.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
    
}
