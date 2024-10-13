package com.example.SecurityApp.service;

import com.example.SecurityApp.dto.LoginRequest;
import com.example.SecurityApp.model.User;
import com.example.SecurityApp.repository.UserRepository;
import com.example.SecurityApp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(LoginRequest loginRequest) throws AuthenticationException {
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new AuthenticationException("User not found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new AuthenticationException("Invalid credentials");
        }

        // Generate the JWT token
        return jwtUtil.generateToken(user.getUsername());
    }
}