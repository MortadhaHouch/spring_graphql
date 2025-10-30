package com.example.demo.models;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "authors")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String name;
    Integer age;
    String address;
    Date createdAt;
    Date updatedAt;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true,fetch =  FetchType.LAZY)
    List<Book> books;
    @PrePersist
    public void prePersist() {
        createdAt = new Date();
        updatedAt = new Date();
    }
    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }
}