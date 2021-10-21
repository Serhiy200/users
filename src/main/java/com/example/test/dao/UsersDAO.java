package com.example.test.dao;

import com.example.test.model.Users;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersDAO {

    private final JdbcTemplate jdbcTemplate;

    public UsersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Users> getAllUsers() {
        String query = "SELECT * FROM account";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper(Users.class));
    }

    public void regUser(Users users) {
        String query = "INSERT INTO account(name,surname,email,password,age) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(query, users.getName(), users.getSurname(), users.getEmail(), users.getPassword(), users.getAge());
    }

    public Users getUserByEmail(String email) {
        String query = "SELECT * FROM account WHERE email = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Users.class), email).stream().findAny().orElse(null);
    }

    public Users login(Users users) throws Exception {
        Users userBD = getUserByEmail(users.getEmail());
        if (userBD.getPassword().trim().equals(users.getPassword())) {
            return userBD;
        } else {
            throw new Exception();
        }
    }

    public Users getUserById(int id) {
        String query = "SELECT * FROM account WHERE id = ?";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Users.class), id).stream().findAny().orElse(null);
    }
}
