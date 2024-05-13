package co.udea.airline.api.controller;

import co.udea.airline.api.model.Person;
import co.udea.airline.api.services.auth.AuthenticationService;
import co.udea.airline.api.model.DTO.auth.PersonRegistrationDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestController
@RequestMapping("/public/api/auth")
@Tag(name = "REGISTER", description = "POST Register person method")
public class PersonController {

    @Autowired
    private AuthenticationService authenticationService;

    @Operation(summary = "Register a person", description = "Register a person with mail and password as credentials.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful registration",
                    content = @Content(schema = @Schema(implementation = Person.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "Invalid person data provided",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody PersonRegistrationDTO registrationDto) {
        try {
            Person person = convertToEntity(registrationDto);
            Person registeredPerson = authenticationService.registerPerson(person);
            return ResponseEntity.ok(registeredPerson);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request: " + e.getMessage());
        }
    }

    private Person convertToEntity(PersonRegistrationDTO dto) {
        Person person = new Person();
        person.setMail(dto.getMail());
        person.setFirstname(dto.getFirstname());
        person.setLastname(dto.getLastname());
        person.setPassword(dto.getPassword());
        person.setBirthdate(dto.getBirthdate());
        person.setPhone(dto.getPhone());
        person.setIdType(dto.getIdType());
        person.setCc(dto.getCc());
        person.setCountry(dto.getCountry());
        person.setCity(dto.getCity());
        person.setProvince(dto.getProvince());
        person.setResidence(dto.getResidence());
        person.setRole(dto.getRole());
        return person;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ex.getBindingResult().getAllErrors());
    }
}
