package com.example.test.main;

import com.example.test.dao.UsersDAO;
import com.example.test.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Main {

    @Autowired
    private UsersDAO usersDAO;

    @GetMapping("/")
    public String index() {
        return "main";
    }

    @GetMapping("/regist")
    public String getRegistration() {
        return "regist";
    }

    @PostMapping("/regist")
    public String postRegistration(@ModelAttribute("user") Users users, Model model) {
        usersDAO.regUser(users);
        model.addAttribute("user", users);
        return "user-info";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("user") Users users, Model model) {
        Users userData = null;
        try {
            userData = usersDAO.login(users);
            model.addAttribute("user", userData);
        } catch (Exception e) {
            return "main";
        }
        return "user-info";
    }

    @GetMapping("/list-users")
    public String getUsersList(Model model) {
        model.addAttribute("users", usersDAO.getAllUsers());
        return "users-list";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", usersDAO.getUserById(id));
        return "user-info";
    }
}
