package com.hithesh.exceptionhandling.service;

import com.hithesh.exceptionhandling.model.Book;

import java.util.List;

public interface LibraryService {
    Book saveBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(int id);
}
