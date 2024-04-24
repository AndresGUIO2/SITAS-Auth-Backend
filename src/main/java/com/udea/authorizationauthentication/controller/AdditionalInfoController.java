package com.udea.authorizationauthentication.controller;

import com.udea.authorizationauthentication.dto.AdditionalUserInfoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AdditionalInfoController {

    @PostMapping("/additional-info")
    public ResponseEntity<?> saveAdditionalUserInfo(@AuthenticationPrincipal OidcUser principal,
                                                    @RequestBody AdditionalUserInfoDTO additionalInfo) {
        // Implementación de lógica para manejar los datos adicionales
        return ResponseEntity.ok("Datos adicionales guardados");
    }
}
