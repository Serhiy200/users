package com.example.test.dao;

import com.example.test.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers() throws Exception;

    void registerUser(User user) throws Exception;

    User getUserById(int id) throws Exception;

    User getUserByEmail(String email) throws Exception;
}
