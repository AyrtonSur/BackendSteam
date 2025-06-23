package com.devweb.backendsteam.repository;

import com.devweb.backendsteam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
