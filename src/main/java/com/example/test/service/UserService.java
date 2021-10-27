package com.example.test.service;

import com.example.test.model.User;

import java.util.List;

public interface UserService {

    User login(User user) throws Exception;

    List<User> getAllUsers() throws Exception;

    void registerUser(User user) throws Exception;

    User getUserById(int id) throws Exception;

    User getUserByEmail(User user) throws Exception;
}
