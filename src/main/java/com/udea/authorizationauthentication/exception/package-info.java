/**
 * This package contains exception classes that are used throughout the
 * Authorization and Authentication system to handle various error conditions.
 *
 * <p>The exception handlers are also located in this package, providing a
 * centralized way to manage errors and exceptions that occur during the
 * operation of the application. Custom exceptions, such as
 * {@link com.udea.authorizationauthentication.exception.PersonAlreadyExistsException},
 * are thrown by the service layer when specific error conditions are met, and are
 * handled globally by the {@link com.udea.authorizationauthentication.exception.CExceptionHandler} class.</p>
 *
 * <p>Using custom exceptions and handlers allows for cleaner error handling and
 * provides more meaningful error messages to the client.</p>
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
package com.udea.authorizationauthentication.exception;
