package co.udea.airline.api.utils.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

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
     * Emisor del token JWT.
     */
    @Value("${JWT_ISSUER}")
    private String jwtIssuer;

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
                .setSubject(authentication.getName())
                .setIssuer(jwtIssuer)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256) // Especifica el algoritmo aquí
                .compact();
    }

    /**
     * Valida el token JWT y extrae los claims.
     *
     * @param token El token JWT a validar.
     * @return Los claims extraídos del token JWT.
     */
    public Claims validateToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
            return Jwts.parser()
                    .setSigningKey(key)
                    .requireIssuer(jwtIssuer)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException | IllegalArgumentException e) {
            throw new RuntimeException("JWT token is invalid or expired");
        }
    }

    /**
     * Extrae el correo electrónico del token JWT.
     *
     * @param token El token JWT del cual extraer el correo electrónico.
     * @return El correo electrónico extraído del token JWT.
     */
    public String getMailFromToken(String token) {
        Claims claims = validateToken(token);
        return claims.getSubject();
    }
}
