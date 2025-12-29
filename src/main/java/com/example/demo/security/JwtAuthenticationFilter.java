package com.example.demo.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserDetailsService uds;

    public JwtAuthenticationFilter(JwtUtil jwtUtil, @Lazy UserDetailsService uds) {
        this.jwtUtil = jwtUtil;
        this.uds = uds;
    }

    
}@Override
protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) 
        throws ServletException, IOException {
    
    final String header = req.getHeader("Authorization");

    if (header == null || !header.startsWith("Bearer ")) {
        chain.doFilter(req, res);
        return;
    }

    try {
        String token = header.substring(7);
        String user = jwtUtil.extractUsername(token);

        if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails details = uds.loadUserByUsername(user);
            
            if (jwtUtil.validateToken(token, details)) {
                var auth = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
    } catch (Exception e) {
        // Log the error but let the chain continue. 
        // SecurityConfig will block the request later if the endpoint is protected.
        logger.error("Cannot set user authentication: {}", e);
    }

    chain.doFilter(req, res);
}