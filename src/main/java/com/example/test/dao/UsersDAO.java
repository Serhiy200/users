package com.example.test.dao;

import com.example.test.model.Users;

import java.util.List;

public interface UsersDAO {
    List<Users> getAllUsers() throws Exception;

    void registerUser(Users users) throws Exception;

    Users login(Users users) throws Exception;

    Users getUserById(int id) throws Exception;
}
