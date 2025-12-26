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
        this.jwtUtil = jwtUtil; this.uds = uds;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        String auth = req.getHeader("Authorization");
        if (auth != null && auth.startsWith("Bearer ")) {
            String token = auth.substring(7);
            String user = jwtUtil.extractUsername(token);
            if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails details = uds.loadUserByUsername(user);
                if (jwtUtil.validateToken(token, details)) {
                    var upat = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
                    upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                    SecurityContextHolder.getContext().setAuthentication(upat);
                }
            }
        }
        chain.doFilter(req, res);
    }
}