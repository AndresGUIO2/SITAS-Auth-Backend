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

    //private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthenticationService(
            PasswordEncoder passwordEncoder,
            @Value("${use.json.storage:false}") boolean useJsonStorage) {
        this.passwordEncoder = passwordEncoder;
    }
    public Person registerPerson(PersonRegistrationDTO registrationDTO){
        Person newPerson = new Person();
        newPerson.setId(registrationDTO.getId());
        newPerson.setIdType(registrationDTO.getIdType());
        newPerson.setFirstname(registrationDTO.getFirstname());
        newPerson.setLastname(registrationDTO.getLastname());
        newPerson.setCity(registrationDTO.getCity());
        newPerson.setRole(registrationDTO.getRole());
        newPerson.setPhone(registrationDTO.getPhone());
        newPerson.setBirthday(registrationDTO.getBirthday());
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
