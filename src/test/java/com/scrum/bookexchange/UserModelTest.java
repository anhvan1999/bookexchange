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
    void testUserModelNotFulfilled() {
        User user = User.builder()
                .email("anhvan1999@gmail.com")
                .password("123").build();

        assertThrows(Exception.class, () -> {
            repos.save(user);
        });
    }
}