
package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.model.User;
import com.example.login.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public boolean validate(String username, String password) {
        User user = repository.findByUsernameAndPassword(username, password);
        return user != null;
    }
}