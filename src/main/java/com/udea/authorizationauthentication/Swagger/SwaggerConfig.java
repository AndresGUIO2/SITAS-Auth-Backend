package com.udea.authorizationauthentication.Swagger;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    private static final String OAUTH_SCHEME = "auth";

    String authURL;

    public OpenAPI api(){
        return new OpenAPI()
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
                .authorizationUrl(authURL + "/oauth2/authorize") // URL de autorización de OAuth2
                .tokenUrl(authURL + "/oauth2/token") // URL de token de OAuth2
                .scopes(new Scopes()); // Definir los ámbitos de OAuth2 si es necesario
        return new OAuthFlows().authorizationCode(oauthFlow); // Utilizar el flujo de autorización de código
    }



}
