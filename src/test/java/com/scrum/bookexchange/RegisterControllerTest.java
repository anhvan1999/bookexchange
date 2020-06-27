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

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegisterPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/register")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testRegisterFormSubmit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/register").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("username", "Something").param("email", "anhvan1999gmail.com").param("password", "1234")
                .param("schoolName", "1234").param("studentId", "1233").param("fullName", "1233")
                .param("phoneNumber", "1233")).andExpect(status().is3xxRedirection());
    }
    
}
