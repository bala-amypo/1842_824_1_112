package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderProfileService;
import java.util.List;

@RestController
public class CredentialHolderProfileController {
    @Autowired
    private CredentialHolderProfileService chps;

    @PostMapping("/audit")
    public CredentialHolderProfile addCredentialHolderProfile(@RequestBody CredentialHolderProfile chp){
        return chps.createHolder(chp);
    }

    @GetMapping("/{id}")
    public CredentialHolderProfile getHolderById(@PathVariable Long id){
        return chps.getByHolderId(id);
    }

    @GetMapping
    public List<AuditTrailRecord> getAll(){
        return atrs.getAllLogs();
    }
}