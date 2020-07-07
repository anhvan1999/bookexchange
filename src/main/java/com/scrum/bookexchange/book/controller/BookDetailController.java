package com.scrum.bookexchange.book.controller;

import java.security.Principal;
import java.util.List;

import com.scrum.bookexchange.book.entity.Book;
import com.scrum.bookexchange.book.entity.BookOption;
import com.scrum.bookexchange.book.repos.BookRepos;
import com.scrum.bookexchange.book.repos.OptionRepos;
import com.scrum.bookexchange.book.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookDetailController {

    @Autowired
    public BookService service;

    @Autowired
    private BookRepos bookRepos;

    @Autowired
    private OptionRepos optionRepos;

    @GetMapping(value = "/book/{id}")
    public String getDetailBook(@PathVariable("id") String id, Principal principal, Model model) {
        Long lid = Long.parseLong(id);
        List<Book> bookOfUser = service.getUserBook();
        Book currentBook = bookRepos.findById(lid).orElseThrow();
        List<BookOption> bookOption = optionRepos.findByBook(currentBook);

        model.addAttribute("username", principal != null ? principal.getName() : null);
        model.addAttribute("bookOfUser", bookOfUser);
        model.addAttribute("current", currentBook);
        model.addAttribute("bookOption", bookOption);

        return "book";
    }
    
}
