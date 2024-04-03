package dev.tim.springboot.service;

import dev.tim.springboot.dto.BookUpdateRequestDTO;
import dev.tim.springboot.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.tim.springboot.model.Book;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private LibraryRepository libraryRepository;
    @Override
    public Book getBook(int id) {
        return libraryRepository.findById(id);
    }

    @Override
    public Book addBook(Book book) {
        return libraryRepository.save(book);
    }

    @Override
    public Book updateBook(int id, String author) {
        Book myBook = libraryRepository.findById(id);
        myBook.setAuthor(author);
        return libraryRepository.save(myBook);
    }

    @Override
    public List<Book> getALlBooks() {
        return libraryRepository.findAll();
    }
}
