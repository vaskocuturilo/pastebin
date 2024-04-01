package com.example.pastebin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
public class Pastebin {
    @Id
    private UUID id;

    @Column(nullable = false)
    @Size(min = 2, max = 255, message = "Min 2, Max 255")
    @NotEmpty(message = "Field is mandatory")
    @NotBlank(message = "Field is mandatory")
    private String author;

    @Column(nullable = false)
    @Size(min = 2, max = 255, message = "Min 2, Max 255")
    @NotEmpty(message = "Field is mandatory")
    @NotBlank(message = "Field is mandatory")
    private String title;

    @Column(nullable = false)
    @Size(min = 2, max = 255, message = "Min 2, Max 255")
    @NotEmpty(message = "Field is mandatory")
    @NotBlank(message = "Field is mandatory")
    private Language language;

    @Column(nullable = false)
    @Size(min = 2, max = 255, message = "Min 2, Max 255")
    @NotEmpty(message = "Field is mandatory")
    @NotBlank(message = "Field is mandatory")
    private String text;

    @Column(nullable = false)
    @NotEmpty(message = "Field is mandatory")
    @NotBlank(message = "Field is mandatory")
    private DateStamp stamp;

    public Pastebin(UUID id, String author, String title, Language language, String text, DateStamp stamp) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.language = language;
        this.text = text;
        this.stamp = stamp;
    }

    public Pastebin() {

    }
}
