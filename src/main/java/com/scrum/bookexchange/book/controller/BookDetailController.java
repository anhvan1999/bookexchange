package com.scrum.bookexchange.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.security.Principal;

@Controller
public class BookDetailController {

    @GetMapping(
            value = "/book/{id}"
    )
    public String getDetailBook(@PathVariable("id") String id, Principal principal, Model model){
        model.addAttribute("username", principal != null ? principal.getName() : null);
        Long lid = Long.parseLong(id);
        System.out.println(id);
        return "book";
    }
}
