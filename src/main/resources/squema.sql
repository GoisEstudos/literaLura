-- Criação da tabela de autores
CREATE TABLE autor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_year INT,
    death_year INT
);

-- Criação da tabela de livros
CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    download_count INT
);

-- Relacionamento muitos-para-muitos entre livros e autores
CREATE TABLE book_autor (
    book_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    PRIMARY KEY (book_id, autor_id),
    FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE,
    FOREIGN KEY (autor_id) REFERENCES autor(id) ON DELETE CASCADE
);

-- Criação da tabela de idiomas dos livros
CREATE TABLE book_languages (
    book_id BIGINT NOT NULL,
    language VARCHAR(255) NOT NULL,
    PRIMARY KEY (book_id, language),
    FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE
);
