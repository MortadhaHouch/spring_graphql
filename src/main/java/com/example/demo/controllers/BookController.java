package com.example.demo.controllers;


import com.example.demo.dtos.BookDTO;
import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepo;
import com.example.demo.services.BookService;
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
    private BookService bookService;
    @QueryMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }
    @QueryMapping
    public Optional<Book> findById(@Argument UUID id){
        return bookService.findById(id);
    }
    @MutationMapping
    public Book createBook(@Argument BookDTO bookDTO){
        return bookService.create(bookDTO);
    }
    @MutationMapping
    public Book updateBook(@Argument BookDTO bookDTO, @Argument UUID id){
        return  bookService.update(bookDTO,id);
    }
    @MutationMapping
    public Boolean deleteBook(@Argument UUID id){
        return bookService.delete(id);
    }
}