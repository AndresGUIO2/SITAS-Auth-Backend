package co.udea.airline.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the authorization and authentication module.
 * This class configures and starts the Spring Boot application.
 * It excludes DataSourceAutoConfiguration to disable automatic DataSource configuration.
 * Additionally, it provides a bean for configuring CORS (Cross-Origin Resource Sharing) filters,
 * allowing requests from any origin, header, and method.
 *
 */
@SpringBootApplication
public class AuthorizationAuthenticationApplication {

	/**
	 * Main method to start the Spring Boot application.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationAuthenticationApplication.class, args);
	}
}
