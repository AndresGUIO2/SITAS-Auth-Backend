package com.udea.authorizationauthentication.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Role {

    private Long id;
    private RoleName name;

    // Si prefieres tener control más fino, puedes poner anotaciones @Getter y @Setter en cada campo individualmente.

    public enum RoleName {
        ROLE_SUPER_ADMIN,
        ROLE_ADMIN,
        ROLE_USER
    }
}
