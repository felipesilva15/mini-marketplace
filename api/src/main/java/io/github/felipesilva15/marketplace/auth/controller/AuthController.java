package io.github.felipesilva15.marketplace.auth.controller;

import io.github.felipesilva15.marketplace.auth.dto.AccessTokenDTO;
import io.github.felipesilva15.marketplace.auth.dto.LoginRequest;
import io.github.felipesilva15.marketplace.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AccessTokenDTO> login(@Valid @RequestBody LoginRequest request) {
        AccessTokenDTO accessTokenDTO = authService.login(request.getEmail(), request.getPassword());

        return ResponseEntity.status(HttpStatus.OK).body(accessTokenDTO);
    }
}
