package com.example.test.dao;

import com.example.test.model.User;
import lombok.RequiredArgsConstructor;
import org.jooq.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.example.test.jooq.public_.tables.Account.ACCOUNT;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO {

    private final DSLContext dsl;

    @Override
    public List<User> getAllUsers() throws Exception {
        try {
            return dsl
                    .select().from(ACCOUNT).fetchInto(User.class);
        } catch (Exception e) {
            throw new Exception("Server Connection Error");
        }
    }

    @Override
    public void registerUser(User users) throws Exception {
        try {
            dsl.insertInto(ACCOUNT, ACCOUNT.NAME, ACCOUNT.SURNAME, ACCOUNT.AGE, ACCOUNT.EMAIL, ACCOUNT.PASSWORD)
                    .values(users.getName(), users.getSurname(), users.getAge(), users.getEmail(), users.getPassword())
                    .execute();
        } catch (Exception e) {
            throw new Exception("Server Connection Error");
        }
    }

    @Override
    public User getUserById(int id) throws Exception {
        try {
            return dsl
                    .select().from(ACCOUNT).where(ACCOUNT.ID.eq(id)).fetchAnyInto(User.class);
        } catch (Exception e) {
            throw new Exception("Server Connection Error");
        }
    }

    @Override
    public User getUserByEmail(String email) throws Exception {
        try {
            return dsl
                    .select().from(ACCOUNT).where(ACCOUNT.EMAIL.eq(email)).fetchAnyInto(User.class);
        } catch (Exception e) {
            throw new Exception("Server Connection Error");
        }
    }
}

