package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderProfileService;
import java.lang.Long;
import java.util.List;

@RestController
public class CredentialHolderProfileController {
    @Autowired
    private CredentialHolderProfileService chps;

    @PostMapping("/holders")
    public CredentialHolderProfile createHolder(@RequestBody CredentialHolderProfile chp){
        return chps.createHolder(chp);
    }

    @GetMapping("/{id}")
    public CredentialHolderProfile getHolderById(@PathVariable Long id){
        return chps.getHolderById(id);
    }

    @GetMapping
    public List<CredentialHolderProfile> getAllHolders(){
        return chps.getAllHolders();
    }

    @PutMapping{"/{id}/status"}
    public CredentialHolderProfile updateHolderStatus(@PathVariable Long id, @RequestParam boolean active){
        return chps.updateHolderStatus(id, active);
    }
}