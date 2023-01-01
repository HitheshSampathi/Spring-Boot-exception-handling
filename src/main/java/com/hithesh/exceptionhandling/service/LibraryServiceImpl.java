package com.hithesh.exceptionhandling.service;

import com.hithesh.exceptionhandling.exception.BookAlreadyExistsException;
import com.hithesh.exceptionhandling.exception.BookNotFoundException;
import com.hithesh.exceptionhandling.model.Book;
import com.hithesh.exceptionhandling.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository repository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book saveBook(Book book) {

        if (repository.existsById(book.getId())) {
            throw new BookAlreadyExistsException();
        }
        return repository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) repository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> book = repository.findById(id);
        if (book.isPresent()) {
            return book.get();
        } else {
            throw new BookNotFoundException("The Book with given id is not found");
        }
    }
}
