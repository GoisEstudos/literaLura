package com.bielsoft.literalura.entities;

import com.bielsoft.literalura.dto.BookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long booksId;

    private String title;

    private List<String> subjects;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "book_id")
    private List<Author> authors;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "book_id")
    private List<Author> translators;

    private List<String> bookshelves;

    private List<String> languages;

    private Boolean copyright;

    private String mediaType;

    @Column(columnDefinition = "TEXT")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "book_id")
    private List<Format> formats;

    private Long download_count;

    public Book(BookDto dto) {
        this.title = dto.title();
        this.authors = dto.authors();
        this.languages = dto.languages();
        this.download_count = dto.download_count();
    }

}
