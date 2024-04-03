package dev.tim.springboot.service;

import dev.tim.springboot.dto.BookUpdateRequestDTO;
import dev.tim.springboot.model.Book;

import java.util.List;

public interface LibraryService {

    public Book getBook(int id);

    public Book addBook(Book book);

    public Book updateBook(int id, String author);

    public List<Book> getALlBooks();
}
