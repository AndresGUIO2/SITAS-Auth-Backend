package co.udea.airline.api.controller;

import co.udea.airline.api.utils.config.security.JwtTokenProvider;
import co.udea.airline.api.model.DTO.auth.JwtResponseDTO;
import co.udea.airline.api.model.DTO.auth.LoginRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Tag(name = "LOGIN", description = "POST login person method")
@RestController
@RequestMapping("/public/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Operation(summary = "Login a person", description = "Authenticate a user with provided credentials and generate a JWT token.")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "Successful authentication, JWT token generated",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = JwtResponseDTO.class)
                    )),
            @ApiResponse(responseCode = "401",
                    description = "Unauthorized, bad credentials provided",
                    content = @Content(
                            mediaType = "text/plain",
                            schema = @Schema(type = "string")
                    ))
    })
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(
            @RequestBody LoginRequestDTO loginRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestDTO.getUsername(),
                            loginRequestDTO.getPassword()
                    )
            );

            String jwt = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new JwtResponseDTO(jwt));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: Bad credentials");
        }
    }
}

