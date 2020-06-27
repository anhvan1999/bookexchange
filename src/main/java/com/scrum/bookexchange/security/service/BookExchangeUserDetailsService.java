package com.scrum.bookexchange.security.service;

import java.util.Optional;

import com.scrum.bookexchange.security.entity.User;
import com.scrum.bookexchange.security.repos.UserRepos;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookExchangeUserDetailsService implements UserDetailsService {

    private final UserRepos userRepos;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepos.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return new BookExchangeUserDetails(user.get());
    }

}