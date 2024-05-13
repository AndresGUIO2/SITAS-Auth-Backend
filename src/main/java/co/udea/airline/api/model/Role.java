package co.udea.airline.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {

    private Long id;
    private RoleName name;

    public enum RoleName {
        ROLE_SUPER_ADMIN,
        ROLE_ADMIN,
        ROLE_USER
    }
}
