package com.minilibraryproject.controller;

import com.minilibraryproject.repository.BookRepository;
import com.minilibraryproject.repository.BorrowedBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrowed_books/")
public class BorrowedBooksController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    private BorrowedBookRepo borrowedBookRepo;


    @GetMapping("/borrow_books/{title_author}")
    public ResponseEntity<String> showBorrowedBooks(@PathVariable String title, String author) {
        borrowedBookRepo.findAll();
        return ResponseEntity.ok("Here are the topics:");
    }
    @GetMapping("borrowed_books/{id}")
    public ResponseEntity<String> showBorrowedBooks(@PathVariable Long id) {
        borrowedBookRepo.findById(id);
        return ResponseEntity.ok("this book has been borrowed");
    }
    @GetMapping("/borrow_book/{isbn}")
    public ResponseEntity<String> borrowBook(@PathVariable int isbn, Long id) {
        bookRepository.findBookByISBN(isbn);
        bookRepository.deleteById(id);
        return ResponseEntity.ok("book borrowed");
    }


    @GetMapping("/borrow_book/{id}")
    public void borrowBook(@PathVariable Long id) {
        bookRepository.findById(id).orElseThrow(()-> new RuntimeException("book not found"));
    }
}
