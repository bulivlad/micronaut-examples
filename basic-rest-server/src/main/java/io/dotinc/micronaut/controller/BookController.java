package io.dotinc.micronaut.controller;

import io.dotinc.micronaut.model.Book;
import io.dotinc.micronaut.service.BookService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import javax.inject.Inject;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author vbulimac on 28/05/2020.
 */

@Controller(value = "/books", produces = MediaType.APPLICATION_JSON)
public class BookController {

    @Inject
    private BookService bookService;

    @Get("/all")
    public List<Book> retrieveAllBooks() {
        return bookService.getAllBooks();
    }

    @Get("/id/{id}")
    public Book retrieveById(@NotNull int id) {
        return bookService.getById(id);
    }

    @Get("/isbn/{isbn}")
    public Book retrieveByISBN(@NotEmpty String isbn) {
        return bookService.getByISBN(isbn);
    }

    @Get("/author/{author}")
    public List<Book> retrieveByAuthor(@NotEmpty @PathVariable("author") String authorName) {
        return bookService.getByAuthor(authorName);
    }

}
