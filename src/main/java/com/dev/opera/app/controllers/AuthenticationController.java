package com.dev.opera.app.controllers;

import com.dev.opera.app.model.dto.UserRegistrationDto;
import com.dev.opera.app.security.AuthenticationService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void registration(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
        authenticationService.register(userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword());
    }
}
