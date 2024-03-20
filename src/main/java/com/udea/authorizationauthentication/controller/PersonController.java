package com.udea.authorizationauthentication.controller;
import com.udea.authorizationauthentication.dto.PersonRegistrationDTO;
import com.udea.authorizationauthentication.model.Person;
import com.udea.authorizationauthentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Handles HTTP POST requests to register a new person.
     *
     * @param registrationDto the DTO containing user registration data
     * @return ResponseEntity containing the registered user entity
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody PersonRegistrationDTO registrationDto) {
        Person person = authenticationService.registerPerson(registrationDto);
        return ResponseEntity.ok(person);
    }
}
