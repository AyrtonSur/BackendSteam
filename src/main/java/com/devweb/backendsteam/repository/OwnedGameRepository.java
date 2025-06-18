package com.devweb.backendsteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.backendsteam.model.OwnedGame;
import com.devweb.backendsteam.model.EmbeddedIds.OwnedGameId;

public interface OwnedGameRepository extends JpaRepository<OwnedGame, OwnedGameId>{
    
}
