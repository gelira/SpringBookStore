package br.com.desenvolvedores.BookStore.controllers;

import br.com.desenvolvedores.BookStore.model.Book;
import br.com.desenvolvedores.BookStore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<Book>> listBooks() {
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Book>(book.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        return new ResponseEntity<Book>(result, HttpStatus.CREATED);
    }

    @PostMapping("/many")
    public ResponseEntity<List<Book>> createManyBooks(@RequestBody List<Book> books) {
        List<Book> result = bookRepository.saveAll(books);
        return new ResponseEntity<List<Book>>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookRepository.delete(book.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
