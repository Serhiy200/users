package com.example.test.controllers;

import com.example.test.model.User;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String index() {
        return "main";
    }

    @GetMapping("/register")
    public String getRegistration() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegistration(@ModelAttribute("user") User user, Model model) {
        try {
            userService.registerUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("user") User user, Model model) {
        try {
            User userData = userService.login(user);
            model.addAttribute("user", userData);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "main";
        }
        return "user";
    }

    @GetMapping("/users")
    public String getUsersList(Model model) {
        try {
            model.addAttribute("users", userService.getAllUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "users";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("user", userService.getUserById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user";
    }
}
