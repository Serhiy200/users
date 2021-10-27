package com.example.test;

import com.example.test.model.User;
import com.example.test.service.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserApplication.class)
@WebAppConfiguration
public class UserApplicationUnitTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    private static UserService userService = mock(UserService.class);

    private static User user1;
    private static User user2;
    private static List<User> usersList = new ArrayList<User>();

    @Before
    public static void init() throws Exception {
        user1 = new User(1, "fds", "fds", "fds", "fds", 21);
        user2 = new User(2, "test", "lastName", "test@gmail.com", "test", 25);
        usersList.add(user1);
        usersList.add(user2);

        when(userService.getAllUsers()).thenReturn(asList(user1, user2));
        when(userService.getUserById(1)).thenReturn(user1);
        when(userService.login(user2)).thenReturn(user2);
        when(userService.getUserByEmail(user1)).thenReturn(user1);
    }

    @Test
    public void getAllUsersTest() throws Exception {
        List<User> users = userService.getAllUsers();
        assertEquals(2, users.size());
        assertEquals(usersList, users);
    }

    @Test
    public void getUserByIdTest() throws Exception {
        User user = userService.getUserById(1);
        assertEquals(user1, user);
    }

    @Test
    public void loginTest() throws Exception {
        User user = userService.login(user2);
        assertEquals(user2, user);
    }

    @Test
    public void getUserByEmail() throws Exception {
        User user = userService.getUserByEmail(user1);
        assertEquals(user1, user);
    }

    @Test
    public void usersTest() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        String uri = "/rest/users";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<User> userList = listFromJson(content);
        assertTrue(userList.size() > 0);
    }

    protected List<User> listFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<User>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
