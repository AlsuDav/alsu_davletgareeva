package ru.itis.cloud.books_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.cloud.books_service.models.Book;
import ru.itis.cloud.books_service.repositories.BooksRepository;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksRepository repository;
    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }
}
