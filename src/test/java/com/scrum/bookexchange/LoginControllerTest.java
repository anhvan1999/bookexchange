package com.scrum.bookexchange;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testLoginPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testLoginFormSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "user@gmail.com").param("password", "user")).andExpect(redirectedUrl("/"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void testLoginFormWrongEmail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "anhvan1999@gmail.com").param("password", "1234"))
                .andExpect(redirectedUrl("/login?error")).andExpect(status().is3xxRedirection());
    }

    @Test
    void testLoginFormWrongPassword() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "user@gmail.com").param("password", "1234")).andExpect(redirectedUrl("/login?error"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void testLoginFormEmailNotValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "anhvan1999gmail.com").param("password", "1234"))
                .andExpect(redirectedUrl("/login?error")).andExpect(status().is3xxRedirection());
    }
}