package com.example.demo.services;

import com.example.demo.dtos.AuthorDTO;
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
    public Author mapDTOtoAuthor(AuthorDTO authorDTO){
        return new Author(
                authorDTO.name(),
                authorDTO.age(),
                authorDTO.address()
        );
    }
    public List<Author> findAll(){
        return authorRepo.findAll();
    }
    public Optional<Author> findById(UUID id){
        return authorRepo.findById(id);
    }
    public Author create(
            AuthorDTO author
    ){
        return authorRepo.save(this.mapDTOtoAuthor(author));
    }

    public Author update(AuthorDTO authorDTO, UUID id) {
        Optional<Author> foundAuthor = authorRepo.findById(id);
        if(foundAuthor.isPresent()){
            Author author = foundAuthor.get();
            author.setName(authorDTO.name());
            author.setAge(authorDTO.age());
            author.setAddress(authorDTO.address());
            return authorRepo.save(author);
        }
        return null;
    }

    public Boolean delete(UUID id) {
        Optional<Author> foundAuthor = authorRepo.findById(id);
        if(foundAuthor.isPresent()){
            authorRepo.delete(foundAuthor.get());
            return true;
        }
        return false;
    }
}