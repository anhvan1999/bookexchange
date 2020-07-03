package com.scrum.bookexchange.image;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class Image {
    @GetMapping(
            value = "/image/{name}",
            produces = {MediaType.IMAGE_JPEG_VALUE}
    )
    public @ResponseBody
    byte[] getImage(@PathVariable("name") String name) throws IOException {
        
        String filePath = System.getProperty("user.dir") + "/upload/" + name;

        InputStream in = new FileInputStream(filePath);
        return IOUtils.toByteArray(in);
    }
}
