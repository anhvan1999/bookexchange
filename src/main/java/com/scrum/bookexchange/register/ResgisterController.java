package com.scrum.bookexchange.register;

import com.scrum.bookexchange.security.entity.User;
import com.scrum.bookexchange.security.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResgisterController {
    @Autowired
    private UserRepos userRepos;

    @GetMapping("/register")
    public String renderPage(){
        return "register";
    }

    @PostMapping(
            path = "/register",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    public String createUser(@RequestParam User user){
        try{
            userRepos.save(user);
            return "success";
        } catch (Exception e) {
            return "fail: " + e.getMessage();
        }
    }
}
