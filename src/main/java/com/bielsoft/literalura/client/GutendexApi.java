package com.bielsoft.literalura.client;

import com.bielsoft.literalura.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "https://gutendex.com", name = "gutendex")
public interface GutendexApi {

    @GetMapping("/books")
    List<BookDto> getBooks(@RequestParam String title);

}
