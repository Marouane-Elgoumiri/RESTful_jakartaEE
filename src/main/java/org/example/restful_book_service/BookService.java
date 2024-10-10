package org.example.restful_book_service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

public class BookService {
    private static List<Book> books = new ArrayList<>();
    public static int idCounter = 0;

    static {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Book>> typeReference = new TypeReference<List<Book>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/books.json");
        try {
            books = mapper.readValue(inputStream, typeReference);
            idCounter = books.size() + 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(long id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public Book addBook(Book book) {
        book.setId(idCounter++);
        books.add(book);
        return book;
    }

    public Book updateBook(long id, Book book) {
        Book existingBook = getBookById(id);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
        }
        return existingBook;
    }

    public void deleteBookById(long id) {
        books.removeIf(book -> book.getId() == id);
    }
}