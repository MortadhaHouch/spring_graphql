package com.example.demo.controllers;

import com.example.demo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;
}