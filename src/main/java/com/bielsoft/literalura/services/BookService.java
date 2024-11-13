package com.bielsoft.literalura.services;

import com.bielsoft.literalura.client.GutendexApi;
import com.bielsoft.literalura.dto.BookDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final GutendexApi gutendexApi;

    public BookService(GutendexApi gutendexApi) {
        this.gutendexApi = gutendexApi;
    }

    public List<BookDto> getBook(String title) {
        List<BookDto> books = gutendexApi.getBooks(title);
        return books.stream()
                .map(x -> new BookDto(x.title(), x.authors(),
                        x.languages(), x.download_count()))
                .collect(Collectors.toList());
    }

}
