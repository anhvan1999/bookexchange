package com.scrum.bookexchange.security.repos;

import java.util.Optional;

import com.scrum.bookexchange.security.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String username);

}
