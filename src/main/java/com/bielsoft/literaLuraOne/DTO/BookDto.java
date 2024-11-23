package com.bielsoft.literaLuraOne.DTO;

import com.bielsoft.literaLuraOne.entities.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record BookDto(@JsonAlias("title") String titulo,
                      @JsonAlias("author") List<Autor> autor,
                      @JsonAlias("language") List<String> idioma,
                      @JsonAlias("download_count") Integer downloads) {
}
