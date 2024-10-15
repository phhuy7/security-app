package com.example.SecurityApp.controller;

import com.example.SecurityApp.dto.AuthRequest;
import com.example.SecurityApp.dto.AuthResponse;
import com.example.SecurityApp.dto.UserRegistrationDTO;
import com.example.SecurityApp.service.AuthService;
import com.example.SecurityApp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private AuthService authService;

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegistrationDTO registrationDto) {
        userService.registerUser(registrationDto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping(value = "/login", produces = "application/json")  // Ensure that the response is JSON
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        String token = authService.login(authRequest.getUsername(), authRequest.getPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }


}
