package com.bielsoft.literaLuraOne.services;

import com.bielsoft.literaLuraOne.DTO.BookDto;
import com.bielsoft.literaLuraOne.entities.Autor;
import com.bielsoft.literaLuraOne.entities.Book;
import com.bielsoft.literaLuraOne.repositories.AutorRepository;
import com.bielsoft.literaLuraOne.repositories.BookRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class GutendexApiService {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    BookRepository bookRepository;

    public List<BookDto> getGutendex(String titulo) throws IOException, InterruptedException, URISyntaxException {
        HttpClient client = HttpClient.newHttpClient();

        String formattedTitulo = titulo.replace(" ", "+");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://gutendex.com/books/?search=" + formattedTitulo))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonNode root = mapper.readTree(response.body());
        JsonNode results = root.path("results");

        List<BookDto> books = new ArrayList<>();

        if (results.isArray() && !results.isEmpty()) {
            JsonNode firstBookNode = results.get(0);
            String title = firstBookNode.path("title").asText();

            JsonNode firstAuthorNode = firstBookNode.path("authors").get(0);
            Autor author = null;
            if (firstAuthorNode != null) {
                String name = firstAuthorNode.path("name").asText();
                Integer birthDate = firstAuthorNode.path("birth_year").isMissingNode() ? null : firstAuthorNode.path("birth_year").asInt();
                Integer deathDate = firstAuthorNode.path("death_year").isMissingNode() ? null : firstAuthorNode.path("death_year").asInt();

                author = autorRepository.findByNome(name)
                        .orElseGet(() -> autorRepository.save(new Autor(name, birthDate, deathDate)));
            }

            List<String> languages = firstBookNode.path("languages").isArray()
                    ? List.of(firstBookNode.path("languages").get(0).asText())
                    : new ArrayList<>();

            Integer downloads = firstBookNode.path("download_count").asInt();

            Book book = new Book(title, author != null ? List.of(author) : new ArrayList<>(), languages, downloads);
            bookRepository.save(book);

            books.add(new BookDto(title, book.getAutor(), languages, downloads));
        }
        return books;
    }

    public List<Book> getGutendexDbBook(){
        return bookRepository.findAll();
    }

    public List<Autor> getGutendexDbAuthor(){
        return autorRepository.findAll();
    }

    public List<Autor> getGutendexDbAuthorAlive(@RequestParam Integer year){
        return autorRepository.findAutoresVivosNoAno(year);
    }

    public List<Book> getGutendexDbBookIdioma(@RequestParam String idioma){
        return bookRepository.findByIdiomaLike(idioma);
    }

}