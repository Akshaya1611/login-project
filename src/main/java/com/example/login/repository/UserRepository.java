package com.example.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}