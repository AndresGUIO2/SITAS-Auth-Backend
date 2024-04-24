package com.udea.authorizationauthentication.service;

import com.udea.authorizationauthentication.dto.PersonRegistrationDTO;
import com.udea.authorizationauthentication.exception.PersonAlreadyExistsException;
import com.udea.authorizationauthentication.model.Person;
//import com.udea.authorizationauthentication.repository.PersonRepository;
import util.JsonUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final boolean useJsonStorage;

    //@Autowired
    //private PersonRepository personRepository;

    public AuthenticationService(PasswordEncoder passwordEncoder, @Value("${use.json.storage:false}") boolean useJsonStorage) {
        this.passwordEncoder = passwordEncoder;
        this.useJsonStorage = useJsonStorage;
    }

    public Person registerPerson(PersonRegistrationDTO registrationDTO) throws PersonAlreadyExistsException, IOException {
        if (emailExists(registrationDTO.getMail())) {
            throw new PersonAlreadyExistsException("Person with email " + registrationDTO.getMail() + " already exists");
        }

        Person newPerson = createPersonFromDTO(registrationDTO);
        savePerson(newPerson);
        return newPerson;
    }

    private boolean emailExists(String email) {
        return JsonUtils.emailExists(email);
    }

    private Person createPersonFromDTO(PersonRegistrationDTO registrationDTO) {
        Person newPerson = new Person();
        newPerson.setId(registrationDTO.getId());
        newPerson.setIdType(registrationDTO.getIdType());
        newPerson.setFirstname(registrationDTO.getFirstname());
        newPerson.setLastname(registrationDTO.getLastname());
        newPerson.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
        newPerson.setMail(registrationDTO.getMail());
        newPerson.setCountry(registrationDTO.getCountry());
        newPerson.setProvince(registrationDTO.getProvince());
        newPerson.setCity(registrationDTO.getCity());
        newPerson.setResidence(registrationDTO.getResidence());
        newPerson.setPhone(registrationDTO.getPhone());
        newPerson.setRole(registrationDTO.getRole());
        newPerson.setBirthdate(registrationDTO.getBirthdate());
        return newPerson;
    }

    private void savePerson(Person person) throws IOException {
        if (useJsonStorage) {
            JsonUtils.savePerson(person);
        } else {
            //personRepository.save(person);
        }
    }
}
