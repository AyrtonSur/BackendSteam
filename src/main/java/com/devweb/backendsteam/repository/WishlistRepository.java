package com.devweb.backendsteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.backendsteam.model.Wishlist;
import com.devweb.backendsteam.model.EmbeddedIds.WishlistId;

public interface WishlistRepository extends JpaRepository<Wishlist, WishlistId>{
    
}
