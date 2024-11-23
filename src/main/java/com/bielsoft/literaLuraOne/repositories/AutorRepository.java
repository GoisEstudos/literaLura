package com.bielsoft.literaLuraOne.repositories;

import com.bielsoft.literaLuraOne.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNome(String name);

    @Query("SELECT a FROM Autor a WHERE (a.nascimento <= :ano AND (a.falecimento IS NULL OR a.falecimento >= :ano)) OR (a.nascimento > :ano AND a.falecimento >= :ano)")
    List<Autor> findAutoresVivosNoAno(@Param("ano") Integer ano);

}
