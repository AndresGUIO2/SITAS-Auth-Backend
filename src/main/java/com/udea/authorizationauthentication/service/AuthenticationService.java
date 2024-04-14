package com.udea.authorizationauthentication.service;

import com.udea.authorizationauthentication.dto.PersonRegistrationDTO;
import com.udea.authorizationauthentication.exception.PersonAlreadyExistsException;
import com.udea.authorizationauthentication.model.Person;
import util.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Service responsible for user authentication and registration.
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@Service
public class AuthenticationService {
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
        Person newPerson = new Person();
        newPerson.setId(registrationDTO.getId());
        newPerson.setIdType(registrationDTO.getIdType());
        newPerson.setFirstname(registrationDTO.getFirstname());
        newPerson.setLastname(registrationDTO.getLastname());
        newPerson.setCity(registrationDTO.getCity());
        newPerson.setMail(registrationDTO.getMail());
        newPerson.setRole(registrationDTO.getRole());
        newPerson.setPhone(registrationDTO.getPhone());
        newPerson.setBirthdate(registrationDTO.getBirthdate());
        newPerson.setCountry(registrationDTO.getCountry());
        newPerson.setCity(registrationDTO.getCity());
        newPerson.setProvince(registrationDTO.getProvince());
        newPerson.setResidence(registrationDTO.getResidence());

        newPerson.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        try {
            JsonUtils.savePerson(newPerson);
        } catch (PersonAlreadyExistsException e) {
            throw e;
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while saving the person data: " + e.getMessage(), e);
        }

        return newPerson;
    }

}
