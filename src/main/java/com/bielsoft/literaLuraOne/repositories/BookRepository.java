package com.bielsoft.literaLuraOne.repositories;

import com.bielsoft.literaLuraOne.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM Book WHERE idioma LIKE %:idioma%", nativeQuery = true)
    List<Book> findByIdiomaLike(@Param("idioma") String idioma);

}
