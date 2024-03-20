package com.udea.authorizationauthentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler class that intercepts specific exceptions thrown by REST controllers.
 * <p>
 * This class is annotated with {@code @RestControllerAdvice} which allows it to be detected by Spring
 * as a global exception handler for controllers, providing a centralized exception handling across all
 * {@code @RequestMapping} methods.
 * </p>
 *  * @author Natalia García
 *  * @author Héctor Güiza
 *  * @author Jeisson Barrantes
 *  * @author Hellen Rubio
 */
@RestControllerAdvice
public class CExceptionHandler {

    /**
     * Handles the {@link PersonAlreadyExistsException} when an attempt is made to register
     * a person with an ID that already exists in the system.
     *
     * @param e the {@code PersonAlreadyExistsException} exception that was thrown
     * @return a {@code ResponseEntity} that contains the conflict status and the error message
     */
    @ExceptionHandler(PersonAlreadyExistsException.class)
    public ResponseEntity<?> handlePersonAlreadyExistsException(PersonAlreadyExistsException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(e.getMessage());
    }
}
