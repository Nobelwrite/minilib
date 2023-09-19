package com.minilibraryproject.controller;

import com.minilibraryproject.globlaexception.UserException;
import com.minilibraryproject.model.Users;
import com.minilibraryproject.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Service
public class CachingClass {
    @Autowired
    private UserRepository userRepository;

    @CacheEvict(cacheNames = "users", key = "#id")
    public ResponseEntity<Users> addUser(@Valid @RequestBody Users users) {
        userRepository.save(users);
        return ResponseEntity.ok(users);
        }
    @CacheEvict(cacheNames = "delete", key = "id")
    public ResponseEntity<Users>deleteUser(@PathVariable Users users) {
        userRepository.delete(users);
        return ResponseEntity.ok(users);
    }
    @CachePut(cacheNames = "updateUser", key = "id")
    public ResponseEntity<Users>updateUser( @PathVariable Long id, @RequestBody Users users){
        Users users1 = userRepository.getUserById(id);
        if(users1 != null){
            if(users.getFullName() != null) {
                users1.setFullName(users.getFullName());

            }
            if (users.getAddress() != null) {
                users1.setAddress(users.getAddress());
            }
            if(users.getAge() != null) {
                users1.setAddress(users.getAddress());
            }
            if (users.getEmail() !=null) {
                users1.setEmail(users.getEmail());
            }
            userRepository.save(users1);
        }
        return ResponseEntity.ok(users1);
    }
    @Cacheable(cacheNames = "updateUser",key = "id")
    public Users findUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UserException("Can't find this user"));
    }
    @Cacheable(cacheNames = "findUserByFullName",key = "#id")
    public Users findUserByFullName(@PathVariable String fullName) {
        return userRepository.findUserByFullName(fullName).orElseThrow(() -> new UserException("Can't find this user"));
    }
    @Cacheable(cacheNames = "findUserByEmail",key = "#email")
    public Users findUserByEmail(@PathVariable String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() -> new UserException("Can't find this user"));
    }
    @Cacheable(cacheNames = "users", key = "#id")
    public List<Users>getAllUsers() {
        return userRepository.findAll();
       
    }
}

