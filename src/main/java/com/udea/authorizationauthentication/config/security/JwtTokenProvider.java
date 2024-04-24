package com.udea.authorizationauthentication.config.security;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Esta clase proporciona funcionalidades para generar tokens JWT (JSON Web Tokens).
 * Utiliza una clave secreta y una fecha de vencimiento para crear tokens válidos.
 */
@Component
public class JwtTokenProvider {

    /**
     * Clave secreta utilizada para firmar los tokens JWT.
     */
    @Value("${JWT_SECRET_KEY}")
    private String jwtSecret;

    /**
     * Duración de validez de los tokens JWT en milisegundos.
     */
    @Value("${JWT_EXPIRATION_MS}")
    private long jwtExpirationInMs;

    /**
     * Genera un token JWT para la autenticación proporcionada.
     *
     * @param authentication La autenticación para la cual se genera el token JWT.
     * @return El token JWT generado.
     */
    public String generateToken(Authentication authentication) {
        // Obtiene la fecha actual
        Date now = new Date();

        // Crea una clave secreta a partir de la clave secreta proporcionada
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));

        // Calcula la fecha de vencimiento del token
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        // Genera el token JWT con la información proporcionada
        return Jwts.builder()
                .claim("sub", authentication.getName())
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(key)
                .compact();
    }
}
