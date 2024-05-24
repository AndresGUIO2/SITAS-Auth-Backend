package co.udea.airline.api.controller;

import co.udea.airline.api.model.Person;
import co.udea.airline.api.model.DTO.auth.PersonInfoDTO;
import co.udea.airline.api.services.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final AuthenticationService authenticationService;

    @Autowired
    public UserController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserDetails(@AuthenticationPrincipal Jwt principal) {
        if (principal == null) {
            return ResponseEntity.status(401).body("Unauthorized: No principal found");
        }

        String email = principal.getClaimAsString("sub");
        Person person = authenticationService.getPersonDetailsByEmail(email);
        if (person == null) {
            return ResponseEntity.status(404).body("User not found");
        }

        PersonInfoDTO personInfoDTO = convertToDTO(person);
        return ResponseEntity.ok(personInfoDTO);
    }

    private PersonInfoDTO convertToDTO(Person person) {
        return new PersonInfoDTO(
                person.getCc(),
                person.getIdType(),
                person.getFirstname(),
                person.getLastname(),
                person.getMail(),
                person.getCountry(),
                person.getProvince(),
                person.getCity(),
                person.getResidence(),
                person.getPhone(),
                person.getRole(),
                person.getBirthdate()
        );
    }
}
