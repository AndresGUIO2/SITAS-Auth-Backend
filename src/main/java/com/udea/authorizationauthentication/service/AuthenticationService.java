package com.udea.authorizationauthentication.service;

import com.udea.authorizationauthentication.dto.PersonRegistrationDTO;
import com.udea.authorizationauthentication.exception.PersonAlreadyExistsException;
import com.udea.authorizationauthentication.model.Person;
import util.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationService {

    // private final PersonRepository personRepository;
    // Dependency injection of repository, possibly used to access the database.
    // Injecting Spring Security's PasswordEncoder for password encoding.
    private final PasswordEncoder passwordEncoder;

    /**
     * Initializes the authentication service.
     * @param passwordEncoder The password encoder for encoding passwords.
     * @param useJsonStorage Boolean indicating whether to use JSON storage or not.
     */

    public AuthenticationService(
            PasswordEncoder passwordEncoder,
            @Value("${use.json.storage:false}") boolean useJsonStorage) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registers a new person in the system.
     * @param registrationDTO Data Transfer Object containing user registration information.
     * @return The newly registered person.
     * @throws PersonAlreadyExistsException If the person already exists in the system.
     * @throws RuntimeException If an error occurs while saving the person data.
     */
    public Person registerPerson(PersonRegistrationDTO registrationDTO){
        // Creating a new instance of Person from the provided DTO data.
        Person newPerson = new Person();
        newPerson.setId(registrationDTO.getId());
        newPerson.setIdType(registrationDTO.getIdType());
        newPerson.setFirstname(registrationDTO.getFirstname());
        newPerson.setLastname(registrationDTO.getLastname());
        newPerson.setCity(registrationDTO.getCity());
        newPerson.setRole(registrationDTO.getRole());
        newPerson.setPhone(registrationDTO.getPhone());
        newPerson.setBirthdate(registrationDTO.getBirthdate());
        newPerson.setCountry(registrationDTO.getCountry());
        newPerson.setCity(registrationDTO.getCity());
        newPerson.setProvince(registrationDTO.getProvince());
        newPerson.setResidence(registrationDTO.getResidence());

        // Encoding the password before storing it in the database.
        newPerson.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        try {
            // Attempting to save the person information in JSON format.
            JsonUtils.savePerson(newPerson);
        } catch (PersonAlreadyExistsException e) { // If the person already exists, a custom exception is thrown.
            throw e;
        } catch (IOException e) { // If there is an I/O error, a general exception is thrown.
            throw new RuntimeException("An error occurred while saving the person data: " + e.getMessage(), e);
        }

        // Returning the newly registered person.
        return newPerson;
    }

}
