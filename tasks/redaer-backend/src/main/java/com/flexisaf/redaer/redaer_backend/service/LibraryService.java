package com.flexisaf.redaer.redaer_backend.service;

import com.flexisaf.redaer.redaer_backend.model.*;
import com.flexisaf.redaer.redaer_backend.repository.LibraryRepository;
import com.flexisaf.redaer.redaer_backend.repository.UserRepository;
import com.flexisaf.redaer.redaer_backend.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public LibraryService(LibraryRepository libraryRepository,
                          UserRepository userRepository,
                          BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    /** ✅ Get all library entries */
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    /** ✅ Get all books in a specific user’s library */
    public List<Library> findByUserId(Long userId) {
        return libraryRepository.findByUser_UserId(userId);
    }

    /** ✅ Add a book to a user’s library */
    @Transactional
    public Library addToLibrary(Long userId, Long bookId, boolean isFavorite) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID " + userId));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with ID " + bookId));

        LibraryId id = new LibraryId(userId, bookId);

        if (libraryRepository.existsById(id)) {
            throw new RuntimeException("Book already exists in user’s library");
        }

        Library entry = new Library();
        entry.setId(id);
        entry.setUser(user);
        entry.setBook(book);
        entry.setFavorite(isFavorite);

        return libraryRepository.save(entry);
    }

    /** ✅ Update whether a book is a favorite or not */
    @Transactional
    public Library updateFavorite(Long userId, Long bookId, boolean favorite) {
        LibraryId id = new LibraryId(userId, bookId);

        Library entry = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library entry not found for user " + userId + " and book " + bookId));

        entry.setFavorite(favorite);
        return libraryRepository.save(entry);
    }

    /** ✅ Remove a book from a user’s library */
    @Transactional
    public void removeFromLibrary(Long userId, Long bookId) {
        LibraryId id = new LibraryId(userId, bookId);

        if (!libraryRepository.existsById(id)) {
            throw new RuntimeException("Library entry not found for user " + userId + " and book " + bookId);
        }

        libraryRepository.deleteById(id);
    }
}
