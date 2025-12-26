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

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/auth") @RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody RegisterRequest req) {
        User user = new User(null, req.getFullName(), req.getEmail(), req.getPassword(), req.getRole());
        User saved = userService.registerUser(user);
        String token = jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());
        return ResponseEntity.ok(new JwtResponse(token, saved.getId(), saved.getEmail(), saved.getRole()));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest req) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        User user = userService.findByEmail(req.getEmail());
        String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
        return ResponseEntity.ok(new JwtResponse(token, user.getId(), user.getEmail(), user.getRole()));
    }
}