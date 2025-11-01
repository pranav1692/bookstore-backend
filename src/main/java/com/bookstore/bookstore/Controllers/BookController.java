package com.bookstore.bookstore.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookstore.bookstore.Entity.Book;
import com.bookstore.bookstore.Repository.BookRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // for React
@RequestMapping("/")
public class BookController {

    @Autowired
    BookRepository repo;
    

    @RequestMapping(value = "/books/", method=RequestMethod.GET)
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    @RequestMapping(value = "/books/", method=RequestMethod.POST)
    public Book createBook(@RequestBody Book book) {
        return repo.save(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = repo.findById(id).orElseThrow();
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPrice(bookDetails.getPrice());
        return repo.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
