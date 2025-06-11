package com.devweb.backendsteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devweb.backendsteam.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
