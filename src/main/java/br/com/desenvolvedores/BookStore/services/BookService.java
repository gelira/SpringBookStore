package br.com.desenvolvedores.BookStore.services;

import br.com.desenvolvedores.BookStore.dto.CreateBookDTO;
import br.com.desenvolvedores.BookStore.dto.UpdateBookDTO;
import br.com.desenvolvedores.BookStore.exceptions.BookNotFoundException;
import br.com.desenvolvedores.BookStore.model.Book;
import br.com.desenvolvedores.BookStore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> listBooks() {
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public Book findBookById(Long id) {
        Optional<Book> bookQuery = bookRepository.findById(id);

        if (bookQuery.isEmpty()) {
            throw new BookNotFoundException();
        }

        return bookQuery.get();
    }

    public Book createBook(CreateBookDTO createBookDTO) {
        Book book = Book.builder()
                .name(createBookDTO.getName())
                .description(createBookDTO.getDescription())
                .author(createBookDTO.getAuthor())
                .genre(createBookDTO.getGenre())
                .build();

        return bookRepository.save(book);
    }

    public Book updateBook(Book book, UpdateBookDTO updateBookDTO) {
        book.setName(updateBookDTO.getName());
        book.setDescription(updateBookDTO.getDescription());
        book.setAuthor(updateBookDTO.getAuthor());
        book.setGenre(updateBookDTO.getGenre());

        return bookRepository.save(book);
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }
}
