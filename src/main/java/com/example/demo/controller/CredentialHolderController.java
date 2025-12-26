package com.example.demo.controller;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.service.CredentialHolderProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/holders")
public class CredentialHolderController {
    private final CredentialHolderProfileService holderService;

    public CredentialHolderController(CredentialHolderProfileService holderService) {
        this.holderService = holderService;
    }

    @PostMapping
    public ResponseEntity<CredentialHolderProfile> create(@RequestBody CredentialHolderProfile profile) {
        return ResponseEntity.ok(holderService.createHolder(profile));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CredentialHolderProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(holderService.getHolderById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<CredentialHolderProfile> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        // PDF Section 7.2 / Test Case t12 calls updateStatus
        return ResponseEntity.ok(holderService.updateStatus(id, active));
    }
}