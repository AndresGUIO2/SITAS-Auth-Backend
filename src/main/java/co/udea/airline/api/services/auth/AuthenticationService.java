package co.udea.airline.api.services.auth;

import co.udea.airline.api.model.Person;
import co.udea.airline.api.model.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Person registerPerson(Person person) {
        if (emailExists(person.getMail())) {
            throw new RuntimeException("Person with email " + person.getMail() + " already exists");
        }

        person.setPassword(passwordEncoder.encode(person.getPassword()));  // Encode the password
        return personRepository.save(person);
    }

    private boolean emailExists(String email) {
        return personRepository.findByMail(email).isPresent();
    }

    public Optional<Person> findPersonByMail(String mail) {
        return personRepository.findByMail(mail);
    }

    public Person getPersonDetailsByEmail(String email) {
        return personRepository.findByMail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
