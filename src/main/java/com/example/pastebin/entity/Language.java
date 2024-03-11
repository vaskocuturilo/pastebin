package com.example.pastebin.entity;

public enum Language {
    PLAIN_TEXT("Plain Text");

    private String lang;

    Language(String lang) {
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }
}
