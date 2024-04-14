package com.udea.authorizationauthentication.service;

import com.udea.authorizationauthentication.model.Person;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import util.JsonUtils;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder PASSWORD_ENCODER;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder) {
        this.PASSWORD_ENCODER = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Person person = JsonUtils.findPersonByMail(mail);
        if (person == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(person.getMail(), person.getPassword(), Collections.emptyList()) {
            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

}
