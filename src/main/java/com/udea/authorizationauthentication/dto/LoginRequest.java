package com.udea.authorizationauthentication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    @NotNull
    @Email(message = "Email should be valid")
    private String username;

    @NotNull
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^" +
            "&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])(?!.*[#='$;%]).{8,}$",
            message = "Password must contain at least one digit, one " +
                    "lowercase letter, one uppercase letter, one symbol, " +
                    "and cannot contain #='$;%")
    private String password;
}
