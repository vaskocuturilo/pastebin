package com.example.pastebin.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Paste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
}
