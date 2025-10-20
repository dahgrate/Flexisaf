package com.flexisaf.redaer.redaer_backend.service;

import com.flexisaf.redaer.redaer_backend.model.Book;
import com.flexisaf.redaer.redaer_backend.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Long id, Book updated) {
        return bookRepository.findById(id).map(b -> {
            b.setTitle(updated.getTitle());
            b.setAuthor(updated.getAuthor());
            b.setDescription(updated.getDescription());
            b.setCoverImage(updated.getCoverImage());
            b.setRating(updated.getRating());
            b.setGenre(updated.getGenre());
            return bookRepository.save(b);
        }).orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
