package com.example.demo.service.impls;

import com.example.demo.service.UserService;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserImpls implements UserService {

    @Autowired
    private UserRepository ur;

    @Override
    public User createCredential(User record) {
        if (record.getStatus() == null) {
            record.setStatus("VALID");
        }
        return crr.save(record);
    }