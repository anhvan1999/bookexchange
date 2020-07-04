package com.scrum.bookexchange.book.controller;

import java.util.List;

import com.scrum.bookexchange.book.entity.Book;
import com.scrum.bookexchange.book.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookTestController {
    
    @Autowired
    public BookService service;

    @GetMapping("/booktest")
    @ResponseBody
    public List<Book> getListOfBook() {
        return service.getUserBook();
    }

}