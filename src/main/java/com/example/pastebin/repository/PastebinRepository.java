package com.example.pastebin.repository;

import com.example.pastebin.entity.Paste;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface PastebinRepository extends CrudRepository<Paste, UUID> {
    @Query(value = "select * from Paste paste WHERE author = :author", nativeQuery = true)
    Optional<Paste> findByAuthor(@Param("author") final String author);
}
