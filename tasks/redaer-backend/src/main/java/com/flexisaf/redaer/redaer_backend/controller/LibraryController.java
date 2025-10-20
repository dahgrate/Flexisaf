package com.flexisaf.redaer.redaer_backend.controller;

import com.flexisaf.redaer.redaer_backend.model.Library;
import com.flexisaf.redaer.redaer_backend.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
@CrossOrigin("*")
public class LibraryController {
    private final LibraryService libraryService;

    public static class AddLibraryRequest {
        public Long userId;
        public Long bookId;
        public Boolean isFavorite = false;
    }

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<Library> getAll() {
        return libraryService.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Library> getByUser(@PathVariable Long userId) {
        return libraryService.findByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Library> add(@RequestBody AddLibraryRequest req) {
        try {
            Library created = libraryService.addToLibrary(req.userId, req.bookId, Boolean.TRUE.equals(req.isFavorite));
            return ResponseEntity.ok(created);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/favorite")
    public ResponseEntity<Library> updateFavorite(@RequestBody AddLibraryRequest req) {
        try {
            Library updated = libraryService.updateFavorite(req.userId, req.bookId, Boolean.TRUE.equals(req.isFavorite));
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> remove(@RequestBody AddLibraryRequest req) {
        try {
            libraryService.removeFromLibrary(req.userId, req.bookId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
