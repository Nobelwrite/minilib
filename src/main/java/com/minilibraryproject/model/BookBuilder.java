package com.minilibraryproject.model;

import jakarta.persistence.Id;

import java.awt.print.Book;

public class BookBuilder {

    private Long id;
    private String title;

    private String author;

    private int ISBN;

    private int publicationYear;


    public BookBuilder() {

    }


    public BookBuilder(Long id, String title, String author, int ISBN, int publicationYear) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }


    public BookBuilder setId(Long id) {
        this.id = id;

        return this;
    }

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setISBN(int ISBN) {
        this.ISBN = ISBN;
        return this;
    }


    public BookBuilder setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }
}
