package dev.tim.springboot.repository;

import dev.tim.springboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Book, Integer> {

    Book findById(int id);
}
