package com.example.demo.controllers;


import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class BookController {
    @Autowired
    private BookRepo bookRepo;
    @QueryMapping
    public List<Book> findAll() {
        return bookRepo.findAll();
    }
    @QueryMapping
    public Optional<Book> findById(@Argument UUID id){
        return bookRepo.findById(id);
    }
    @MutationMapping
    public Book createBook(@Argument Book book){
        return bookRepo.save(book);
    }
}