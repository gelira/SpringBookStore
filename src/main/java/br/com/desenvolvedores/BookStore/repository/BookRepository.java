package br.com.desenvolvedores.BookStore.repository;

import br.com.desenvolvedores.BookStore.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
