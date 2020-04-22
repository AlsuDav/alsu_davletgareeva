package ru.itis.cloud.books_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.cloud.books_service.models.Book;
import ru.itis.cloud.books_service.services.BooksService;

import java.util.List;
@RestController
public class BookController {
    @Autowired
    private BooksService service;
    @GetMapping("/books")
    public List<Book> getNotes(){
        return service.getAll();
    }

}

