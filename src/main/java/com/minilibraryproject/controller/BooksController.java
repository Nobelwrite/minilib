package com.minilibraryproject.controller;

import com.minilibraryproject.model.Books;
import com.minilibraryproject.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books/")
public class BooksController {
   @Autowired
   private BookRepository bookRepository;

   @Autowired
   private CacheBook cacheBook;

   @GetMapping("/books/{book}")
   public List<Books> getAllBooks() {
       return bookRepository.findAll();
}
@PostMapping("/addBook/")
public ResponseEntity<String> addBook(@Valid @RequestBody Books book) {
    return cacheBook.addBook(book);
}
@GetMapping("/isBorrowed/{id}")
    public boolean isBorrowed(Long id) {
      return cacheBook.isBorrowed(id);
}
@DeleteMapping("/deleteBook/{id}")
public ResponseEntity<String>deleteBook(@PathVariable Long id){
     return cacheBook.deleteBook(id);
}
@GetMapping("/find_books/{id}")
public ResponseEntity<String> findById(@PathVariable Long id) {
     return cacheBook.findById(id);
}
@GetMapping("/findByAuthor/{title_author}")
public ResponseEntity<String >findBookByTitleAndAuthor(@PathVariable String title, String author) {
    return cacheBook.findBookByTitleAndAuthor(title, title);
}

public ResponseEntity<String>findBookByISBN(@RequestParam int isbn) {
      return cacheBook.findBookByISBN(isbn);
}

}
