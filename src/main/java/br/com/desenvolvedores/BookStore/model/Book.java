package br.com.desenvolvedores.BookStore.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private String description;
    private String author;
    private String genre;

    @Builder
    private static Book bookFactory(String name, String description, String author, String genre) {
        Book book = new Book();
        book.setName(name);
        book.setDescription(description);
        book.setAuthor(author);
        book.setGenre(genre);

        return book;
    }
}
