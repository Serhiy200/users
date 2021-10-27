package com.example.test.service;

import com.example.test.dao.UserDAO;
import com.example.test.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public User login(User users) throws Exception {
        User userBD = userDAO.getUserByEmail(users.getEmail());
        if (userBD == null || !userBD.getPassword().equals(users.getPassword())) {
            throw new Exception("Wrong password or email");
        } else {
            return userBD;
        }
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return userDAO.getAllUsers();
    }

    @Override
    public void registerUser(User user) throws Exception {
        userDAO.registerUser(user);
    }

    @Override
    public User getUserById(int id) throws Exception {
        return userDAO.getUserById(id);
    }


    @Override
    public User getUserByEmail(User user) throws Exception{
        return userDAO.getUserByEmail(user.getEmail());
    }
}

