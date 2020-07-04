package com.scrum.bookexchange.book.repos;

import java.util.List;

import com.scrum.bookexchange.book.entity.Book;
import com.scrum.bookexchange.security.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepos extends JpaRepository<Book, Long> {
    List<Book> findByOwner(User user);
}
