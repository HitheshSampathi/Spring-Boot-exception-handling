package com.hithesh.exceptionhandling.controller;

import com.hithesh.exceptionhandling.exception.BookAlreadyExistsException;
import com.hithesh.exceptionhandling.exception.BookNotFoundException;
import com.hithesh.exceptionhandling.model.Book;
import com.hithesh.exceptionhandling.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class LibraryController {
    private final LibraryService service;

    @Autowired
    public LibraryController(LibraryService service) {
        this.service = service;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        try {
            Book savedBook = service.saveBook(book);
            return new ResponseEntity<Book>(savedBook, HttpStatus.CREATED);
        } catch (BookAlreadyExistsException ex) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book already exists");
        }
    }

    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<List<Book>>(service.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
//        try{
        return new ResponseEntity<Book>(service.getBookById(id), HttpStatus.OK);
//        }catch(BookNotFoundException bookNotFoundException ){
//            return new ResponseEntity(bookNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
//        }
    }

//    @ExceptionHandler(value = BookAlreadyExistsException.class)
//    public ResponseEntity handleBookAlreadyExistsException(BookAlreadyExistsException bookAlreadyExistsException) {
//        return new ResponseEntity("Book already exists", HttpStatus.CONFLICT);
//    }

}
