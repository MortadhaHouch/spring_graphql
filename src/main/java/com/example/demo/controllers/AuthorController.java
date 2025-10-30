package com.example.demo.controllers;

import com.example.demo.dtos.AuthorDTO;
import com.example.demo.models.Author;
import com.example.demo.models.Book;
import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @QueryMapping
    public List<Author> findAll(){
        return authorService.findAll();
    }
    @QueryMapping
    public Optional<Author> findById(@Argument UUID id){
        return authorService.findById(id);
    }
    @MutationMapping
    public Author createAuthor(@Argument AuthorDTO author){
        return authorService.create(author);
    }
    @MutationMapping
    public Author updateAuthor(@Argument AuthorDTO author, @Argument UUID id){
        return authorService.update(author,id);
    }
    @MutationMapping
    public Boolean deleteAuthor(@Argument UUID id){
        return authorService.delete(id);
    }
}