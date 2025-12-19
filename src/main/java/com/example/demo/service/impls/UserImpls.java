package com.example.demo.service.impls;

import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.lang.Long;
import java.lang.

@Service
public class UserImpls implements UserService {

    @Autowired
    private UserRepository ur;

    @Override
    public User registerUser(User user) {
        return ur.save(user);
    }

    @Override
    public List<User> findByEmail(String email){
    return ur.findByEmail(email);
    }
}