package com.scrum.bookexchange.security.repos;

import com.scrum.bookexchange.security.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepos extends JpaRepository<Book, Long> {

}