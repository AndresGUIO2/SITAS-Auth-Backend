package com.udea.authorizationauthentication.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
