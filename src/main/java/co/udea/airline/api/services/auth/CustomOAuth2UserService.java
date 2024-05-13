package co.udea.airline.api.services.auth;

import co.udea.airline.api.model.Person;
import co.udea.airline.api.utils.exception.PersonAlreadyExistsException;
import co.udea.airline.api.utils.JsonUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        Map<String, Object> attributes = userRequest.getAdditionalParameters();

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");

        try {
            Person person = JsonUtils.findPersonByMail(email);
            if (person == null) {
                person = new Person();
                person.setMail(email);
                person.setFirstname(name.split(" ")[0]);
                person.setLastname(name.contains(" ") ? name.split(" ")[1] : ""); // manejar nombres sin apellido
                JsonUtils.savePerson(person);
            }
        } catch (PersonAlreadyExistsException | IOException e) {
            throw new RuntimeException("Person already exists: " + e.getMessage(), e);
        }

        Set<SimpleGrantedAuthority> authorities = userRequest.getClientRegistration().getScopes().stream()
                .map(scope -> new SimpleGrantedAuthority("SCOPE_" + scope))
                .collect(Collectors.toSet());

        return new DefaultOAuth2User(authorities, attributes, "email");
    }
}
