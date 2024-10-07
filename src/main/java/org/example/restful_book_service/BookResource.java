package org.example.restful_book_service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/books")
public class BookResource {
    private BookService bookService = new BookService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@PathParam("id") long id) {
        return bookService.getBookById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBook(Book book) {
        Book createdBook = bookService.addBook(book);
        return  Response.status(Response.Status.CREATED).entity(createdBook).build();
    }

    @PUT
    @Path("/{id}")
    @Produces
    @Consumes
    public Response updateBook(@PathParam("id") long id, Book book) {
        Book updatedBook = bookService.updateBook(id,book);
        return  updatedBook != null ? Response.ok(updatedBook).build() : Response.status(Response.Status.OK).entity(updatedBook).build();
    }
    @DELETE
    @Path("/id")
    public Response deleteBook(@PathParam("id") long id) {
        bookService.deleteBookById(id);
        return Response.noContent().build();
    }
}