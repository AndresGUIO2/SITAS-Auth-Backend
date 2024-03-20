package com.udea.authorizationauthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CExceptionHandler {
    @ExceptionHandler(PersonAlreadyExistsException.class)
    public ResponseEntity<?> handlePersonAlreadyExistsException(PersonAlreadyExistsException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }
}
