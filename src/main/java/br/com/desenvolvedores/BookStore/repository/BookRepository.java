package br.com.desenvolvedores.BookStore.repository;

import br.com.desenvolvedores.BookStore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
