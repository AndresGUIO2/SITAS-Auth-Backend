package com.udea.authorizationauthentication.exception;

/**
 * Custom exception class to signal that an attempt to register a person with a duplicate identifier has occurred.
 * This exception is thrown when a person with the same ID already exists in the system and a new registration
 * is attempted with that same ID.
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
public class PersonAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new {@code PersonAlreadyExistsException} with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public PersonAlreadyExistsException(String message) {
        super(message);
    }
}
