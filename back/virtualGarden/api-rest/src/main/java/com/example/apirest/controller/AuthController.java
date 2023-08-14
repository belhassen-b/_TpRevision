package com.example.apirest.controller;

import com.example.apirest.dto.request.LoginRequestDTO;
import com.example.apirest.dto.response.LoginResponseDTO;
import com.example.apirest.dto.request.RegisterRequestDTO;
import com.example.apirest.dto.response.RegisterResponseDTO;
import com.example.apirest.security.JWTGenerator;
import org.example.entity.UserApp;
import org.example.port.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@CrossOrigin("*")
@RestController
public class AuthController {
    private final AuthenticationManager authenticationManager;

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator generator;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, PasswordEncoder passwordEncoder, JWTGenerator generator) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.generator = generator;
    }


    @PostMapping("login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(LoginResponseDTO.builder().token(generator.generateToken(authentication)).build());
        }catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    @PostMapping("register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        try {
            UserApp userApp = userService.createUser(registerRequestDTO.getUsername(), passwordEncoder.encode(registerRequestDTO.getPassword()));
            return ResponseEntity.ok(RegisterResponseDTO.builder().id(userApp.getId()).message("User created").build());
        }catch (Exception ex) {
            throw new RuntimeException();
        }
    }
}
