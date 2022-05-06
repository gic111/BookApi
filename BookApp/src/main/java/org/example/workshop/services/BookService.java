package org.example.workshop.services;

import org.example.workshop.model.Book;

import java.util.List;

public interface BookService {
    Book getBookById(Long bookId);

    Book addBook(Book bookToAdd);

    void updateBook(Book bookToUpdated);

    void deleteBook(Long bookId);

    List<Book> getBooks();
}
