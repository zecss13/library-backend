package com.zecss13.library.repository;

import com.zecss13.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // JpaRepository provides all the necessary CRUD methods
    // Additional custom queries can be defined here if needed
}