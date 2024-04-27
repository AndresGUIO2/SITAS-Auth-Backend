package com.udea.authorizationauthentication.controller;
import com.udea.authorizationauthentication.dto.PersonRegistrationDTO;
import com.udea.authorizationauthentication.model.Person;
import com.udea.authorizationauthentication.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;

/**
 * This class represents the controller for handling person-related HTTP requests.
 * It maps incoming requests to methods for register a new person.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@Tag(name = "REGISTER", description = "POST Register person method")
@RestController
@RequestMapping("/public/api/auth")
public class PersonController {

    @Autowired
    private AuthenticationService authenticationService;

    @Operation(summary = "Register a person", description = "Register a person with mail and password as credentials.")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = {
                            @Content(schema = @Schema(implementation = Person.class),
                            mediaType = "application/json") }),
            @ApiResponse(responseCode = "404",
                    content = {
                    @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500",
                    content = {
                    @Content(schema = @Schema()) }) })
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody PersonRegistrationDTO registrationDto) {
        try {
            Person person = authenticationService.registerPerson(registrationDto);
            return ResponseEntity.ok(person);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error processing request: " + e.getMessage());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ex.getBindingResult().getAllErrors());
    }
}
