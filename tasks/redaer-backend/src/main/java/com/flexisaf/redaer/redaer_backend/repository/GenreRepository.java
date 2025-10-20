package com.flexisaf.redaer.redaer_backend.repository;

import com.flexisaf.redaer.redaer_backend.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
