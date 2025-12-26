package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService us;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User request) {

        User saved = us.registerUser(request);

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                saved.getEmail(),
                saved.getPassword(),
                new ArrayList<>()
        );

        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(
                new JwtResponse(saved.getId(), saved.getEmail(), saved.getRole(), token)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = us.findByEmail(request.getEmail());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>()
        );

        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(
                new JwtResponse(user.getId(), user.getEmail(), user.getRole(), token)
        );
    }
}
