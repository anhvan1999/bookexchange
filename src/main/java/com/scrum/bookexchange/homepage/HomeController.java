package com.scrum.bookexchange.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import com.scrum.bookexchange.book.entity.Book;
import com.scrum.bookexchange.book.repos.BookRepos;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class HomeController {

    private BookRepos bookRepos;

    @GetMapping("")
    public String getHome(Principal principal, Model model) {
        List<Book> bookList = bookRepos.findAll();

        Collections.reverse(bookList);

        model.addAttribute("bookList", bookList);
        model.addAttribute("username", principal != null ? principal.getName() : null);
        return "home";
    }

    @GetMapping("/profile")
    public String getLoginPage(Principal principal, Model model) {
        model.addAttribute("username", principal != null ? principal.getName() : null);
        return "profile";
    }

    @GetMapping("/book")
    public String getBookPage(Principal principal, Model model) {
        model.addAttribute("username", principal != null ? principal.getName() : null);
        return "book";
    }

}
