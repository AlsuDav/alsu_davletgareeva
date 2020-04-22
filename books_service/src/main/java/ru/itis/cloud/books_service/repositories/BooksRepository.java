package ru.itis.cloud.books_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.cloud.books_service.models.Book;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book,Long> {
    List<Book> findAll();
}
