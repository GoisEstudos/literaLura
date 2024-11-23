# literaLura

O projeto **literaLura** é uma iniciativa para o desafio de leitura, onde os participantes podem se envolver com livros de diversos gêneros e registrar suas leituras. O sistema permite a busca e visualização de livros com informações detalhadas, como título, autor e contagem de downloads.

## Tecnologias Utilizadas

- **Java** (para o backend)
- **Spring Boot** (para desenvolvimento de APIs)
- **Gradle** (como sistema de build)
- **API externa de livros** (para buscar informações sobre os livros)

## Funcionalidades

- Busca de livros por título.
- Exibição de detalhes sobre o livro, incluindo autor, idiomas e contagem de downloads.

## Como Executar

1. Clone o repositório:

    ```bash
    git clone https://github.com/GoisEstudos/literaLura.git
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd literaLura
    ```

3. Execute o projeto utilizando o Gradle:

    ```bash
    ./gradlew bootRun
    ```

4. Acesse a API através do Swagger em `http://localhost:8080/swagger-ui`.

## Contribuições

Sinta-se à vontade para contribuir com melhorias ou novos recursos. Para contribuir:

1. Fork este repositório.
2. Crie uma nova branch (`git checkout -b feature/nova-funcionalidade`).
3. Comite suas alterações (`git commit -am 'Adiciona nova funcionalidade'`).
4. Push para a branch (`git push origin feature/nova-funcionalidade`).
5. Abra um pull request.
