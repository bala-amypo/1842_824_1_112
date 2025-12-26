package com.example.demo.security;
import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {
    private String secret = "secret_key_for_digital_credential_engine_verification_2025";
    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder().claim("userId", userId).claim("email", email).claim("role", role)
                .setSubject(email).setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }
    public String extractUsername(String token) { return extractClaim(token, Claims::getSubject); }
    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        return resolver.apply(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody());
    }
    public boolean validateToken(String token, UserDetails details) {
        return extractUsername(token).equals(details.getUsername());
    }
}