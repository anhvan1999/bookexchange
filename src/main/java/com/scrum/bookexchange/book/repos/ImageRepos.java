package com.scrum.bookexchange.book.repos;

import com.scrum.bookexchange.book.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepos extends JpaRepository<Image, Long> {

}
