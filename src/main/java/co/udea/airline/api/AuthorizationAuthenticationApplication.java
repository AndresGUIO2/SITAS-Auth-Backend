package co.udea.airline.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Main application class for the authorization and authentication module.
 * This class configures and starts the Spring Boot application.
 * It excludes DataSourceAutoConfiguration to disable automatic DataSource configuration.
 * Additionally, it provides a bean for configuring CORS (Cross-Origin Resource Sharing) filters,
 * allowing requests from any origin, header, and method.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@SpringBootApplication()
public class AuthorizationAuthenticationApplication {

	/**
	 * Main method to start the Spring Boot application.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationAuthenticationApplication.class, args);
	}

	/**
	 * Configures a CORS filter to allow requests from any origin, header, and method.
	 *
	 * @return a CorsFilter instance configured to allow all origins, headers, and methods
	 */	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(false);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}