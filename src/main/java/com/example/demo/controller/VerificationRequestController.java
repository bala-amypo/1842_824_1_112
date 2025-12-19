package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.service.VerificationRequestService;
import java.util.List;

@RestController
@RequestMapping("/api/verification")
public class VerificationRequestController {

    @Autowired
    private VerificationRequestService vrs;

    @PostMapping
    public VerificationRequest initiateVerification(
            @RequestBody VerificationRequest request) {
        return vrs.initiateVerification(request);
    }

    @PutMapping("/{id}/process")
    public VerificationRequest processVerification(@PathVariable Long id) {
        return vrs.processVerification(id);
    }

    @GetMapping("/credential/{credentialId}")
    public List<VerificationRequest> getByCredential(
            @PathVariable Long credentialId) {
        return vrs.getRequestsByCredential(credentialId);
    }

    @GetMapping
    public List<VerificationRequest> getAllRequests() {
        return vrs.getAllRequests();
    }

    @GetMapping("/{id}")
    public VerificationRequest getById(@PathVariable Long id) {
        return vrs.processVerification(id);
    }
}
