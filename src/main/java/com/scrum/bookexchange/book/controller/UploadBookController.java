package com.scrum.bookexchange.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UploadBookController {

    @GetMapping("/upload")
    public String getUpload(Principal principal, Model model){
        model.addAttribute("username", principal != null ? principal.getName() : null);
        return "upload";
    }
    
}
