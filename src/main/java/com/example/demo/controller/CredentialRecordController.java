package com.example.demo.controller;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.service.CredentialRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/credentials")
public class CredentialRecordController {

    @Autowired
    private CredentialRecordService credentialService;

    @PostMapping
    public CredentialRecord createCredential(@RequestBody CredentialRecord record) {
        return credentialService.createCredential(record);
    }

    @PutMapping("/{id}")
    public CredentialRecord updateCredential(@PathVariable Long id, @RequestBody CredentialRecord updated) {
        return credentialService.updateCredential(id, updated);
    }

    @GetMapping("/holder/{holderId}")
    public List<CredentialRecord> getCredentialsByHolder(@PathVariable Long holderId) {
        return credentialService.getCredentialsByHolder(holderId);
    }

    @GetMapping("/code/{credentialCode}")
    public CredentialRecord getCredentialByCode(@PathVariable String credentialCode) {
        return credentialService.getCredentialByCode(credentialCode);
    }

    @GetMapping
    public List<CredentialRecord> getAllCredentials() {
        return credentialService.getAllCredentials();
    }
}
