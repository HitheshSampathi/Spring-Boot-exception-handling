package com.hithesh.exceptionhandling.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private int id;
    private String title;
    private String author;
    private int publishedYear;

    public Book() {
    }

    public Book(int id, String title, String author, int publishedYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
}
