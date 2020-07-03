package com.scrum.bookexchange.upload;
import lombok.Data;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

@Data
public class BookFormData {
    private String title;
    private List<MultipartFile> images;
    private List<String> options;
}