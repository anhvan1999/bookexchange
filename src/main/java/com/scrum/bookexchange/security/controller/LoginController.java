package com.scrum.bookexchange.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String getLoginPage(@RequestParam(name = "error", required = false, defaultValue = "false") Boolean error,
            Model model) {
        model.addAttribute("error", error);
        return "login";
    }

}
