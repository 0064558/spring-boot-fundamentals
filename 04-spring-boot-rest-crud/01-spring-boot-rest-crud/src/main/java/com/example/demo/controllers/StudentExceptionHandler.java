package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {
    // Add a excpetion handler using @ExceptionHandler
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleExcpetion(StudentNotFoundException exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler... to catch any exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<StudentErrorResponse> handleExcpetion(Exception exc) {
        // create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
