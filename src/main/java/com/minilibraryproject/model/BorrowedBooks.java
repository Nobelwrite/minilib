package com.minilibraryproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "borrowed_books")
public class BorrowedBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "title")
   private Books books;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private Books authors;



}

