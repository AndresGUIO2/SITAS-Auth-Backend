package com.udea.authorizationauthentication.controller;
import com.udea.authorizationauthentication.dto.PersonRegistrationDTO;
import com.udea.authorizationauthentication.model.Person;
import com.udea.authorizationauthentication.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;

/**
 * This class represents the controller for handling person-related HTTP requests.
 * It maps incoming requests to methods for register a new person.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@RestController
@RequestMapping("/public/api/auth")
public class PersonController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody PersonRegistrationDTO registrationDto) {
        try {
            Person person = authenticationService.registerPerson(registrationDto);
            return ResponseEntity.ok(person);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error processing request: " + e.getMessage());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ex.getBindingResult().getAllErrors());
    }
}
