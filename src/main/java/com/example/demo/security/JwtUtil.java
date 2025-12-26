package com.example.demo.security;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {
    private String secret = "secret_key_for_digital_credential_engine_verification_2025";
    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .claim("userId", userId).claim("email", email).claim("role", role)
                .setSubject(email).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }
}