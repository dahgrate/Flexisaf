package com.flexisaf.redaer.redaer_backend.repository;

import com.flexisaf.redaer.redaer_backend.model.Library;
import com.flexisaf.redaer.redaer_backend.model.LibraryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, LibraryId> {
    List<Library> findByUser_UserId(Long userId);
}
