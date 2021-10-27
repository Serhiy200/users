package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mainPageTest() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("main"));
    }

    @Test
    public void usersTest() throws Exception {
        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("users"));
    }

    @Test
    public void loginTest() throws Exception {
        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("email", "asda")
                        .param("password", "asda"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("user"));
    }

    @Test
    public void registrationTest() throws Exception {
        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("name", "test2")
                        .param("surname", "test_lastname2")
                        .param("email", "asda@gmail")
                        .param("password", "asda")
                        .param("age", "32")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("user"));
    }
}
