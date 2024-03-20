package com.udea.authorizationauthentication.controller;
import com.udea.authorizationauthentication.dto.PersonRegistrationDTO;
import com.udea.authorizationauthentication.model.Person;
import com.udea.authorizationauthentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/api/auth")
public class PersonController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody PersonRegistrationDTO registrationDto) {
        Person person = authenticationService.registerPerson(registrationDto);
        return ResponseEntity.ok(person);
    }
}
