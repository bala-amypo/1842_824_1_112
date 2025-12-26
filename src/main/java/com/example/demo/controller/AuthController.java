// package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;
// import java.util.List;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {
//     @Autowired
//     private UserService us;

//     @PostMapping
//     public User registerUser(@RequestBody User user) {
//         return us.registerUser(user);
//     }

//     @GetMapping("/login/{email}")
//     public List<User> findByEmail(@PathVariable String email){
//         return us.findByEmail(email);
//     }
// }



package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.JwtResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    // 🔐 LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        // ✅ FIXED TOKEN GENERATION
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

    // 📝 REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User request) {

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        User saved = userRepository.save(user);

        // ✅ FIXED TOKEN GENERATION
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
}
