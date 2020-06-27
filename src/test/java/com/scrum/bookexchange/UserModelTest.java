package com.scrum.bookexchange;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.scrum.bookexchange.security.entity.User;
import com.scrum.bookexchange.security.repos.UserRepos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class UserModelTest {
    
    @Autowired
    UserRepos repos;

    @Test
    void testUserModelNotValid() {
        User user = User.builder()
                .email("anhvan1999@gmail.com")
                .password("123").build();

        assertThrows(Exception.class, () -> {
            repos.save(user);
        });
    }

    @Test
    void testUserModelValid() {
        User user = User.builder()
                .email("anhvan1999@gmail.com")
                .active(true)
                .fullName("Dang Anh Van")
                .password("12334")
                .schoolName("HCMUT")
                .studentId("21333")
                .avatarPath("foo")
                .phoneNumber("1923776")
                .role("USER").build();
        repos.save(user);
    }
}