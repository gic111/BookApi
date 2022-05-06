package org.example.workshop.controller;

import lombok.RequiredArgsConstructor;
import org.example.workshop.model.Book;
import org.example.workshop.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/books")
// Generuje konstruktor dla wszystkich pól z modyfikatorem final
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

//  public BookController(BookService bookService) {
//    this.bookService = bookService;
//  }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/{bookId:\\d+}")
    public Book getById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    // PUT /books/15
    // {
    //  "id":31
    @PutMapping("/{bookId:\\d+}")
    public Book updateBook(@PathVariable Long bookId, @RequestBody Book book) {
        if (!bookId.equals(book.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Path and body ids don't match");
        }
        bookService.updateBook(book);
        return book;
    }

    @DeleteMapping("/{bookId:\\d+}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }
}