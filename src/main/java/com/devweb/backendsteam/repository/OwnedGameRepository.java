package com.devweb.backendsteam.repository;

import com.devweb.backendsteam.model.EmbeddedIds.OwnedGameId;
import com.devweb.backendsteam.model.OwnedGame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnedGameRepository extends JpaRepository<OwnedGame, OwnedGameId> {}
