package org.example.restful_book_service;
import jakarta.json.bind.annotation.JsonbProperty;

public class Book {
    @JsonbProperty("id")
    private long id;

    @JsonbProperty("title")
    private String title;

    @JsonbProperty("author")
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
