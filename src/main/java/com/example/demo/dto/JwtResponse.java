package com.example.demo.dto;
import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
public class JwtResponse {
    private String token;
    private Long id;
    private String email;
    private String role;
}