package ru.itis.cloud.books_service.services;

import ru.itis.cloud.books_service.models.Book;

import java.util.List;

public interface BooksService {
    List<Book> getAll();
}
