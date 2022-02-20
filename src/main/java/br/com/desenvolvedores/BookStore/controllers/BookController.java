package br.com.desenvolvedores.BookStore.controllers;

import br.com.desenvolvedores.BookStore.dto.CreateBookDTO;
import br.com.desenvolvedores.BookStore.dto.UpdateBookDTO;
import br.com.desenvolvedores.BookStore.model.Book;
import br.com.desenvolvedores.BookStore.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<Book> listBooks() {
        return bookService.listBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") Long id) {
        return bookService.findBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@Valid @RequestBody CreateBookDTO createBookDTO) {
        return bookService.createBook(createBookDTO);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") Long id, @Valid @RequestBody UpdateBookDTO updateBookDTO) {
        Book book = bookService.findBookById(id);
        return bookService.updateBook(book, updateBookDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("id") Long id) {
        Book book = bookService.findBookById(id);
        bookService.deleteBook(book);
    }
}
