package co.udea.airline.api.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/*
@Controller
@RequestMapping("/oauth2")
public class OAuth2Controller {

    @GetMapping("/loginSuccess")
    @ResponseBody
    public String getLoginInfo(@AuthenticationPrincipal OidcUser principal) {
        return "User email: " + principal.getEmail();
    }
}
*/