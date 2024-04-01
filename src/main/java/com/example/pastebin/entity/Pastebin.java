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
   // @Size(min = 2, max = 255, message = "Min 2, Max 255")
    //@NotEmpty(message = "Field is mandatory")
    //@NotBlank(message = "Field is mandatory")
    private Language language;

    @Column(nullable = false)
    @Size(min = 2, max = 255, message = "Min 2, Max 255")
    @NotEmpty(message = "Field is mandatory")
    @NotBlank(message = "Field is mandatory")
    private String text;

    @Column(nullable = false)
    //@NotEmpty(message = "Field is mandatory")
    //@NotBlank(message = "Field is mandatory")
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DateStamp getStamp() {
        return stamp;
    }

    public void setStamp(DateStamp stamp) {
        this.stamp = stamp;
    }
}
