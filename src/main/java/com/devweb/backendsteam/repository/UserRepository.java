package com.devweb.backendsteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.backendsteam.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
