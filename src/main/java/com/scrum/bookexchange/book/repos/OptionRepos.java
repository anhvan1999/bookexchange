package com.scrum.bookexchange.book.repos;

import com.scrum.bookexchange.book.entity.BookOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepos extends JpaRepository<BookOption, Long> {

}