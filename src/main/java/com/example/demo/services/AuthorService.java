package com.example.demo.services;

import com.example.demo.models.Author;
import com.example.demo.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    public List<Author> findAll(){
        return authorRepo.findAll();
    }
    public Optional<Author> findById(UUID id){
        return authorRepo.findById(id);
    }
}