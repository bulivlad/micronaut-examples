package io.dotinc.micronaut.service;

import io.dotinc.micronaut.model.Book;
import io.dotinc.micronaut.repository.BookRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * @author vbulimac on 28/05/2020.
 */

@Singleton
public class BookService {

    @Inject
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public Book getById(int id) {
        return bookRepository.getById(id);
    }

    public Book getByISBN(String isbn) {
        return bookRepository.getByISBN(isbn);
    }

    public List<Book> getByAuthor(String author) {
        return bookRepository.getByAuthor(author);
    }
}
