package com.bielsoft.literalura.dto;

import com.bielsoft.literalura.entities.Author;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDto(@JsonAlias("title") String title,
                      @JsonAlias("authors") List<Author> authors,
                      @JsonAlias("languages") List<String> languages,
                      @JsonAlias("download_count") Long download_count) {
}
