// package com.example.demo.service.impls;

// import com.example.demo.service.UserService;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.entity.User;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;
// import java.lang.Long;
// import java.lang.String;

// @Service
// public class UserServiceImpl implements UserService {

//     @Autowired
//     private UserRepository ur;

//     @Override
//     public User registerUser(User user) {
//         return ur.save(user);
//     }

//     @Override
//     public List<User> findByEmail(String email){
//     return ur.findByEmail(email);
//     }
// }


package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("User with this email already exists.");
        }
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
    }
}