package com.example.demo.repositories;

import com.example.demo.models.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthorRepo extends JpaRepository<Author, UUID>, PagingAndSortingRepository<Author, UUID> {
    Page<Author> findAll(Pageable pageable);
    Optional<Author> findById(UUID id);
}