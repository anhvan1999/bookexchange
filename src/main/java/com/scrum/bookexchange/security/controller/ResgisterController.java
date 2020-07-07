package com.scrum.bookexchange.security.controller;

import com.scrum.bookexchange.security.entity.User;
import com.scrum.bookexchange.security.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ResgisterController {

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private PasswordEncoder encoder;

    private Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    private boolean validationEmail(String email) {
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }

    private boolean validationNumberPhone(String number) {
        return number.matches("^\\+?\\d{7,14}$");
    }

    private boolean validationStudentId(String studentId) {
        return studentId.matches("^[0-9A-Za-z]+$");
    }

    @GetMapping("/register")
    public String renderPage(@RequestParam(name = "error", defaultValue = "false", required = false) boolean error,
            Model model) {
        model.addAttribute("error", error);
        return "register";
    }

    @PostMapping(path = "/register", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String createUser(UserFormData form) {

        try {
            if (!this.validationEmail(form.getEmail())) {
                return "redirect:/register?invalid=email";
            }

            if (!this.validationNumberPhone(form.getPhoneNumber())) {
                return "redirect:/register?invalid=number_phone";
            }

            if (!this.validationStudentId(form.getStudentId())) {
                return "redirect:/register?invalid=student_id";
            }

            User user = User.builder().avatarPath("").studentId(form.getStudentId()).fullName(form.getFullName())
                    .phoneNumber(form.getPhoneNumber()).password(encoder.encode(form.getPassword()))
                    .email(form.getEmail()).role("USER").active(true).schoolName(form.getSchoolName()).build();

            userRepos.save(user);
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/register?error=true";
        }
    }
    
}
