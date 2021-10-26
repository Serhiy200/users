package com.example.test.dao;

import com.example.test.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.jooq.*;
import com.example.test.jooq.public_.tables.Account;

import java.util.List;

@Component
public class UsersDAOImpl implements UsersDAO {

    Account ACCOUNT = Account.ACCOUNT;
    private final DSLContext dsl;

    @Autowired
    public UsersDAOImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    @Override
    public List<Users> getAllUsers() throws Exception {
        try {
            List<Users> usersList = dsl
                    .select().from(ACCOUNT).fetchInto(Users.class);
            return usersList;
        } catch (Exception e) {
            throw new Exception("Server Connection Error");
        }
    }

    @Override
    public void registerUser(Users users) throws Exception {
        try {
            dsl.insertInto(ACCOUNT, ACCOUNT.NAME, ACCOUNT.SURNAME, ACCOUNT.AGE, ACCOUNT.EMAIL, ACCOUNT.PASSWORD)
                    .values(users.getName(), users.getSurname(), users.getAge(), users.getEmail(), users.getPassword())
                    .execute();
        } catch (Exception e) {
            throw new Exception("Server Connection Error");
        }
    }

    public Users getUserById(int id) throws Exception {
        try {
            Users user = dsl
                    .select().from(ACCOUNT).where(ACCOUNT.ID.eq(id)).fetchAnyInto(Users.class);
            return user;
        } catch (Exception e) {
            throw new Exception("Server Connection Error");
        }
    }

    public Users getUserByEmail(String email) throws Exception {
        try {
            Users user = dsl
                    .select().from(ACCOUNT).where(ACCOUNT.EMAIL.eq(email)).fetchAnyInto(Users.class);
            return user;
        } catch (Exception e) {
            throw new Exception("Server Connection Error");
        }
    }

    @Override
    public Users login(Users users) throws Exception {
        Users userBD = getUserByEmail(users.getEmail());
        if (userBD == null || !userBD.getPassword().equals(users.getPassword())) {
            throw new Exception("Wrong password or email");
        } else {
            return userBD;
        }

    }
}
