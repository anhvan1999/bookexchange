package com.scrum.bookexchange.book.repos;

import com.scrum.bookexchange.book.entity.Book;
import com.scrum.bookexchange.book.entity.BookOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepos extends JpaRepository<BookOption, Long> {
    List<BookOption> findByBook(Book book);
}
