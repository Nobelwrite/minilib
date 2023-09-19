package com.minilibraryproject.controller;

import com.minilibraryproject.model.Books;
import com.minilibraryproject.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CacheBook {
    @Autowired
    private BookRepository bookRepository;

    @Cacheable(cacheNames = "books", key= "#book")
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }
    @CacheEvict(cacheNames = "addBook", key = "#book")
    public ResponseEntity<String> addBook(@Valid @RequestBody Books book) {
        bookRepository.save(book);
        return  ResponseEntity.ok("saved");
    }
    @Cacheable(cacheNames = "isBorrowed", key = "#id")
    public boolean isBorrowed(Long id) {
        Optional<Books> books = bookRepository.findById(id);
        return true;
    }
    @CacheEvict(cacheNames="deleteBook", key= "id")
    public ResponseEntity<String>deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return ResponseEntity.ok("book deleted");
    }
    @Cacheable(cacheNames = "findbooks", key = "id")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        bookRepository.findById(id);
        return ResponseEntity.ok("Here is the book");
    }
    @Cacheable(cacheNames = "findByTitleAuthor", key = "title, author")
    public ResponseEntity<String >findBookByTitleAndAuthor(@PathVariable String title, String author) {
        bookRepository.findBookByAuthorAndTitle(title, author);
        return ResponseEntity.ok("Here is your boook");
    }
    @Cacheable(cacheNames = "findBookByISBN", key = "#isbn")
    public ResponseEntity<String>findBookByISBN(@RequestParam int isbn) {
        bookRepository.findBookByISBN(isbn);
        return ResponseEntity.ok("Here is the book");
    }

}
