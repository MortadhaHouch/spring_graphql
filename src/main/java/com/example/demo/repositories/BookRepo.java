package com.example.demo.repositories;

import com.example.demo.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.GraphQlRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@GraphQlRepository
public interface BookRepo extends JpaRepository<Book, UUID>, PagingAndSortingRepository<Book, UUID> {
    List<Book> findAll();
    Page<Book> findAll(Pageable pageable);
    Optional<Book> findById(UUID id);
}