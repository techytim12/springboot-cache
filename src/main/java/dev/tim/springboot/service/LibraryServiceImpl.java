package dev.tim.springboot.service;

import dev.tim.springboot.dto.BookUpdateRequestDTO;
import dev.tim.springboot.repository.LibraryRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import dev.tim.springboot.model.Book;

import java.util.List;

@Service
@Log
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private LibraryRepository libraryRepository;
    @Override
    @Cacheable(cacheNames = "books", key = "#id")
    public Book getBook(int id) {
        log.info("Getting book");
        return libraryRepository.findById(id);
    }

    @Override
    public Book addBook(Book book) {
        return libraryRepository.save(book);
    }

    @Override
    @CachePut(cacheNames = "books", key = "#id")
    public Book updateBook(int id, String author) {
        Book myBook = libraryRepository.findById(id);
        myBook.setAuthor(author);
        return libraryRepository.save(myBook);
    }

    @Override
    public List<Book> getALlBooks() {
        return libraryRepository.findAll();
    }

    @Override
    @CacheEvict(cacheNames = "books", key = "#id")
    public void deleteBook(int id) {
        log.info("Deleting book");
        libraryRepository.deleteById(id);
    }
}
