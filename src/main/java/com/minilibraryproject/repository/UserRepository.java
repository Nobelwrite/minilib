package com.minilibraryproject.repository;

import com.minilibraryproject.model.Books;
import com.minilibraryproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT * FROM users WHERE id = :id", nativeQuery = true)
    Users getUserById(@Param("id") Long id);
   // Books findUserById(Long id);
    Optional<Users>findUserByEmail(String email);

    Optional<Users>findUserByFullName(String fullName);



    // Optional<Users>updateUser(String fullName);


}
