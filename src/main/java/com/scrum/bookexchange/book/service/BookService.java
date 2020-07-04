package com.scrum.bookexchange.book.service;

import java.util.List;

import com.scrum.bookexchange.book.entity.Book;
import com.scrum.bookexchange.book.repos.BookRepos;
import com.scrum.bookexchange.security.entity.User;
import com.scrum.bookexchange.security.repos.UserRepos;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {

    private final UserRepos repos;

    private final BookRepos bookRepos;

    public List<Book> getUserBook() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = repos.findByEmail(username).orElseThrow();
        List<Book> listBook = bookRepos.findByOwner(user);
        return listBook;
    }

}
