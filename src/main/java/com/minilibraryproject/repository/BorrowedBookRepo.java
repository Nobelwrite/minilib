package com.minilibraryproject.repository;

import com.minilibraryproject.model.BorrowedBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedBookRepo extends JpaRepository<BorrowedBooks, Long> {

}
