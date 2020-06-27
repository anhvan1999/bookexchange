package com.scrum.bookexchange.register;

import com.scrum.bookexchange.security.entity.User;
import com.scrum.bookexchange.security.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public String createUser(UserFormData form){

        try{
            User user = User.builder()
                    .avatarPath("")
                    .studentId(form.getStudentId())
                    .fullName(form.getFullName())
                    .phoneNumber(form.getPhoneNumber())
                    .password(form.getPassword())
                    .email(form.getEmail())
                    .role("USER")
                    .active(true)
                    .schoolName(form.getSchoolName())
                    .build();

            userRepos.save(user);
            return "success";
        } catch (Exception e) {
            return "fail: " + e.getMessage();
        }
    }
}
