package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.login.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    // Open login page
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // Check username and password
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        if (service.validate(username, password)) {
            model.addAttribute("message", "Login Successful!");
            return "home";   // home.html page
        } else {
            model.addAttribute("message", "Invalid Username or Password");
            return "login";  // return back to login page
        }
    }
}