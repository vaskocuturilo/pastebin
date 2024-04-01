package com.example.pastebin.repository;

import com.example.pastebin.entity.Pastebin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface PastebinRepository extends CrudRepository<Pastebin, UUID> {

    @Query(value = "select * from Pastebin paste WHERE text LIKE CONCAT('%', :text, '%') ORDER BY text asc ", nativeQuery = true)
    Optional<Pastebin> findByText(@Param("text") final String text);

    @Query(value = "select * from Pastebin paste WHERE title = :title ORDER BY title asc ", nativeQuery = true)
    Optional<Pastebin> findByTitle(@Param("title") final String title);

    @Query(value = "select * from Pastebin paste WHERE author = :author ORDER BY author asc ", nativeQuery = true)
    Optional<Pastebin> findByAuthor(@Param("author") final String author);
}
