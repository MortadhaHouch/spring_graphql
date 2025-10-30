package com.example.demo.services;

import com.example.demo.dtos.BookDTO;
import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;
    public Book mapDTOtoBook(BookDTO bookDTO){
        Book book = new Book();
        book.setTitle(bookDTO.title());
        book.setSummary(bookDTO.summary());
        book.setPublishedDate(bookDTO.publishedDate());
        return book;
    }
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Optional<Book> findById(UUID id) {
        return bookRepo.findById(id);
    }

    public Book update(BookDTO bookDTO, UUID id) {
        Optional<Book> foundBook = bookRepo.findById(id);
        if(foundBook.isPresent()){
            Book book = foundBook.get();
            book.setTitle(bookDTO.title());
            book.setSummary(bookDTO.summary());
            book.setPublishedDate(bookDTO.publishedDate());
            return bookRepo.save(book);
        }
        return null;
    }

    public Book create(BookDTO bookDTO) {
        return bookRepo.save(this.mapDTOtoBook(bookDTO));
    }

    public Boolean delete(UUID id) {
        Optional<Book> foundBook = bookRepo.findById(id);
        if(foundBook.isPresent()){
            bookRepo.delete(foundBook.get());
            return true;
        }
        return false;
    }
}