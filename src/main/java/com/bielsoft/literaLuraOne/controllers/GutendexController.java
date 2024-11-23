package com.bielsoft.literaLuraOne.controllers;

import com.bielsoft.literaLuraOne.DTO.BookDto;
import com.bielsoft.literaLuraOne.entities.Autor;
import com.bielsoft.literaLuraOne.entities.Book;
import com.bielsoft.literaLuraOne.services.GutendexApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gutendex")
public class GutendexController {

    @Autowired
    private GutendexApiService gutendexApi;

    @GetMapping("/search")
    public ResponseEntity<BookDto> getGutendex(@RequestParam String titulo) throws Exception {
        return ResponseEntity.ok(gutendexApi.getGutendex(titulo).get(0));
    }

    @GetMapping("/dbBooks")
    public ResponseEntity<List<Book>> getGutendexDbBooks() {
        return ResponseEntity.ok(gutendexApi.getGutendexDbBook());
    }

    @GetMapping("/dbAuthors")
    public ResponseEntity<List<Autor>> getGutendexDbAuthor() {
        return ResponseEntity.ok(gutendexApi.getGutendexDbAuthor());
    }

    @GetMapping("/dbAuthorsAlive")
    public ResponseEntity<List<Autor>> getGutendexDbAuthorAlive(@RequestParam Integer year) {
        return ResponseEntity.ok(gutendexApi.getGutendexDbAuthorAlive(year));
    }

    @GetMapping("/dbBooksIdioma")
    public ResponseEntity<List<Book>> getGutendexDbBookIdioma(@RequestParam String idioma) {
        return ResponseEntity.ok(gutendexApi.getGutendexDbBookIdioma(idioma));
    }
}
