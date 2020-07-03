package com.scrum.bookexchange.upload;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.scrum.bookexchange.security.entity.Book;
import com.scrum.bookexchange.security.repos.BookRepos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private BookRepos bookRepos;
    @Autowired
    private OptionRepos optionRepos;
    @Autowired
    private ImageRepos imageRepos;
    String VIETNAMESE_DIACRITIC_CHARACTERS 
        = "ẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ";

    Pattern namePattern =
    Pattern.compile("(?:[" + VIETNAMESE_DIACRITIC_CHARACTERS + "]|[A-Z])++",
                    Pattern.CANON_EQ |
                    Pattern.CASE_INSENSITIVE |
                    Pattern.UNICODE_CASE);

    @GetMapping(
        path = "/register",
        consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    public boolean validationName(String name){
        Matcher namePatternMatcher = namePattern.matcher(name);
        return namePatternMatcher.find();
    }
    public String uploadBook(BookFormData form){
        try{
            if(!this.validationName(form.getName())){
                return "redirect:/upload?invalid=name";
            }

            Book book = Book.builder()
                    .name(form.getName())
                    .build();
            bookRepos.save(book);
            for (int i=0;i<form.getOption().length;i++){
                Option option = Option.builder()
                                .wayToExchange(form.getOption()[i])
                                .build();
                optionRepos.save(option);
            }
            for (int i=0;i<form.getImage().length;i++){
                Image image = Image.builder()
                                .image(form.getImage()[i])
                                .build();
                imageRepos.save(image);
            }
            return "redirect:/upload?result=success";
        } catch (Exception e) {
            return "redirect:/upload?error=true";
        }
    }
}