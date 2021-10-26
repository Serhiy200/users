package com.example.test.controllers;

import com.example.test.dao.UsersDAO;
import com.example.test.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UsersDAO usersDAO;

    public UserController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @GetMapping("/")
    public String index() {
        return "main";
    }

    @GetMapping("/register")
    public String getRegistration() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegistration(@ModelAttribute("user") Users users, Model model) {
        try {
            usersDAO.registerUser(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("user", users);
        return "user";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("user") Users users, Model model) {
        try {
            Users userData = usersDAO.login(users);
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
            model.addAttribute("users", usersDAO.getAllUsers());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "users";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        try {
            model.addAttribute("user", usersDAO.getUserById(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user";
    }
}
