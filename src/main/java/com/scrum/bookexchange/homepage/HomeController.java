package com.scrum.bookexchange.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("")
public class HomeController {
    
    @GetMapping("")
    public String getHome(Principal principal, Model model) {
        model.addAttribute("username", principal != null ? principal.getName() : null);
        return "home";
    }
    // @GetMapping("homepage")
    // public String getLoginPage(){
    //     return "home";
    // }

}