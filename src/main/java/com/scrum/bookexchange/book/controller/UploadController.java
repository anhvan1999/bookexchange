package com.scrum.bookexchange.book.controller;

import java.io.File;
import java.security.Principal;

import com.scrum.bookexchange.book.entity.Book;
import com.scrum.bookexchange.book.entity.BookOption;
import com.scrum.bookexchange.book.repos.BookRepos;
import com.scrum.bookexchange.book.repos.OptionRepos;
import com.scrum.bookexchange.security.entity.User;
import com.scrum.bookexchange.security.repos.UserRepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Transactional
public class UploadController {

    @Autowired
    private BookRepos bookRepos;

    @Autowired
    private OptionRepos optionRepos;

    @Autowired
    private UserRepos userRepos;

    @PostMapping(path = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    @ResponseBody
    public String uploadBook(Principal principal, BookFormData form) {

        User user = userRepos.findByEmail(principal.getName()).orElse(null);
        String url = System.getProperty("user.dir") + "/upload/";

        MultipartFile multipartFile = form.getImages().get(0);

        File file = new File(url + System.currentTimeMillis() + multipartFile.getOriginalFilename());

        try {
            multipartFile.transferTo(file);
            Book book = Book.builder().owner(user).title(form.getTitle()).defaultImageLink(file.getName()).build();

            bookRepos.save(book);

            for (String o : form.getOptions()) {
                BookOption option = BookOption.builder().book(book).optionString(o).build();
                optionRepos.save(option);
            }

            return "success";
        } catch (Exception e) {
            return "error";
        }

    }
}