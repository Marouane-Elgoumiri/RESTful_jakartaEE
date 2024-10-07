package org.example.restful_book_service;
import java.util.List;
import java.util.ArrayList;

public class BookService {
    private static List<Book> books = new ArrayList<>();
    public static int idCounter = 0;

    public List<Book> getBooks() {
        return books;
    }
    public Book getBookById(long id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }
    public Book addBook(Book book) {
        book.setId(idCounter);
        books.add(book);
        return book;
    }
    public Book updateBook(long id, Book book) {
        Book existingBook = getBookById(id);
        if(existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
        }
        return existingBook;
    }
    public void deleteBookById(long id) {
        books.removeIf(book -> book.getId() == id);
    }
}
