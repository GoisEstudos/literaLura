package com.bielsoft.literalura.controllers;

import com.bielsoft.literalura.dto.BookDto;
import com.bielsoft.literalura.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getBook(@RequestParam String title) {
        return ResponseEntity.ok(bookService.getBook(title));
    }

}
