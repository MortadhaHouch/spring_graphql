package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookService {
    @Autowired
    BookRepo bookRepo;

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Optional<Book> findById(UUID id) {
        return bookRepo.findById(id);
    }
}