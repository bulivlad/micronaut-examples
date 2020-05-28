package io.dotinc.micronaut.repository;

import io.dotinc.micronaut.model.Book;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author vbulimac on 28/05/2020.
 */

@Singleton
public class BookRepository {

    static List<Book> books = new ArrayList<>();
    static {
        Random random = new Random();
        IntStream.range(0, 10).forEach(value -> {
            Book book = Book.builder()
                    .id(value)
                    .isbn(String.valueOf(Math.abs(random.nextInt())))
                    .author("Author" + random.nextInt(10))
                    .name("Awesome book" + random.nextInt(10))
                    .price(Math.abs(random.nextDouble()))
                    .build();
            books.add(book);
        });
    }

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(new Book());
    }

    public Book getByISBN(String isbn) {
        return books.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst().orElse(new Book());
    }

    public List<Book> getByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

}
