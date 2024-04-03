package dev.tim.springboot.controller;

import dev.tim.springboot.dto.BookUpdateRequestDTO;
import dev.tim.springboot.model.Book;
import dev.tim.springboot.service.LibraryService;
import dev.tim.springboot.service.LibraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(libraryService.getALlBooks());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
        return ResponseEntity.ok(libraryService.getBook(id));
    }

    @PostMapping("/add-book")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok(libraryService.addBook(book));
    }

    @PatchMapping("/update-book")
    public ResponseEntity<Book> updateBook(@RequestBody BookUpdateRequestDTO dto){
        return ResponseEntity.ok(libraryService.updateBook(dto.getId(), dto.getAuthor()));
    }

    @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id){
        libraryService.deleteBook(id);
        return ResponseEntity.ok("Book deleted");
    }
}
