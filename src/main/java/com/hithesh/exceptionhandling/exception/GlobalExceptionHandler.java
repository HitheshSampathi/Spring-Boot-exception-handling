package com.hithesh.exceptionhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity bookNotFoundException(BookNotFoundException bookNotFoundException) {
        return new ResponseEntity("The Book with given id is not found", HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(value = IllegalStateException.class)
    public ResponseEntity databaseConnectionFailedException(Exception exception) {
        return new ResponseEntity<>("The Application is unable to connect to database", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}