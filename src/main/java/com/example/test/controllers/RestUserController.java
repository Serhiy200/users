package com.example.test.controllers;

import com.example.test.model.User;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class RestUserController {

    private final UserService userService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @GetMapping("/users")
    public List<User> getUsersList() {
        try {
            return userService.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
