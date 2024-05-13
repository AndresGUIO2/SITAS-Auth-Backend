package co.udea.airline.api.utils.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    private static final String OAUTH_SCHEME = "auth";

    String authURL;

    @Bean
    public OpenAPI api(){
        return new OpenAPI()
                .info(new Info()
                        .title("Authorization and Authentication Module API")
                        .version("0.0.1")
                        .description("This API exposes endpoints to Authorization and Authentication module for SITAS.")
                        .contact(new Contact()
                                .name("Hellen Jakeline Rubio Casas")
                                .email("hellen.rubio@udea.edu.co")))
                .addSecurityItem(new SecurityRequirement()
                        .addList(OAUTH_SCHEME))
                        .components(new Components()
                                .addSecuritySchemes(OAUTH_SCHEME, createOAuthScheme()))
                        .addSecurityItem(new SecurityRequirement().addList(OAUTH_SCHEME));
    }
    private SecurityScheme createOAuthScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.OAUTH2).flows(createOAuthFlows());
    }
    private OAuthFlows createOAuthFlows() {
        final var oauthFlow = new OAuthFlow()
                .authorizationUrl(authURL + "/protocol/openid-connect" + "/auth")
                .refreshUrl(authURL + "/protocol/openid-connect" + "/token")
                .tokenUrl(authURL + "/protocol/openid-connect" + "/token")
                .scopes(new Scopes());
        return new OAuthFlows().authorizationCode(oauthFlow);
    }



}
