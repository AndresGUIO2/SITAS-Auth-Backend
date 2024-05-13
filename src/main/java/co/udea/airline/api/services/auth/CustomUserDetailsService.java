package co.udea.airline.api.services.auth;

import co.udea.airline.api.model.Person;
import co.udea.airline.api.model.jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import co.udea.airline.api.utils.JsonUtils;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public CustomUserDetailsService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Person person = personRepository.findByMail(mail).orElseThrow(
                () -> new UsernameNotFoundException("User not found with email: " + mail)
        );

        return new org.springframework.security.core.userdetails.User(
                person.getMail(),
                person.getPassword(),
                true, true, true, true,
                getAuthorities(person)
        );
    }
    private List<SimpleGrantedAuthority> getAuthorities(Person person) {
        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole()));
    }
}
