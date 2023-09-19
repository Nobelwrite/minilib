package com.minilibraryproject.controller;

import com.minilibraryproject.model.Users;
import com.minilibraryproject.repository.UserRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private CachingClass cachingClass;

    @PostMapping("/users/{addUser}")
    public ResponseEntity<Users> addUser(@Valid @RequestBody Users users, BindingResult bindingResult) {
       //return userRepository.save(users);
            if (bindingResult.hasErrors()) {
                ResponseEntity.ok("User not created");
            }
           return cachingClass.addUser(users);

        }


      // return cachingClass.addUser(users);
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok("Use has been deleted");
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<Users>updateUser( @PathVariable Long id, @RequestBody Users users){
        cachingClass.updateUser(id, users);
      return ResponseEntity.ok(users);
    }
    @GetMapping("/users/{findById}")
    public ResponseEntity<Users> findById(@PathVariable Long id) {
        //return cachingClass.findUserById(id);
        return ResponseEntity.ok(cachingClass.findUserById(id));
    }
    @GetMapping("/users/{fullName}")
    public ResponseEntity<Users> findUserByFullName(@PathVariable String fullName) {
        return ResponseEntity.ok(cachingClass.findUserByFullName(fullName));
    }
    @GetMapping("/users/{email}")
    public ResponseEntity<Users> findUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(cachingClass.findUserByEmail(email));
    }

    }
