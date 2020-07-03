package com.scrum.bookexchange.book.repos;

import com.scrum.bookexchange.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepos extends JpaRepository<Book, Long> {
    
}
