package com.example.test;

import com.example.test.jooq.public_.tables.Account;
import org.jooq.DSLContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserApplicationTests {

    @Autowired
    DSLContext dsl;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mainPageTest() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

    @Test
    public void usersTest() throws Exception {
        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"));
    }

    @Test
    public void loginTest() throws Exception {
        this.mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("email", "asda")
                        .param("password", "asda")).andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }

    @Test
    public void registrationTest() throws Exception {
        this.mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("name", "test")
                        .param("surname", "test_lastname")
                        .param("email", "asda@gmail")
                        .param("password", "asda")
                        .param("age", "32")).andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse();
    }

    @Test()
    void testDB() {
        assertEquals("Problem selecting one item from DB", 1, dsl.selectOne().fetch().size());

        assertEquals("error username with id 1", "name1", dsl.select(Account.ACCOUNT.NAME).from(Account.ACCOUNT).where(Account.ACCOUNT.ID.eq(1)).fetchOne().value1());
    }
}
