package com.pabloinsdrums.apigestionoauth.controller;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @PostMapping("/logout")
    public String logoutOk(HttpSecurity http) {
        try {
            http.logout(logoutConfig -> {
                logoutConfig.logoutSuccessUrl("login?logout")
                        .deleteCookies("JSESSIONID")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true);
            });

            return "login?logout";
        } catch (Exception e) {
            throw new RuntimeException("Error in logoutOk "+ e);
        }
    }
}
