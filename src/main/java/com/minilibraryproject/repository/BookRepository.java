package com.minilibraryproject.repository;

import com.minilibraryproject.model.Books;
import com.minilibraryproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Books, Long> {

   // @Query(value = "SELECT * FROM books WHERE id = :id", nativeQuery = true)
   // void delete(Books books);

    Optional<Books>findBookByISBN(int isbn);

    Optional<Books>findBookByAuthorAndTitle(String title, String author);

}
