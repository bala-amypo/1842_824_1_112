package com.example.demo.service.impls;

import com.example.demo.service.VerificationRequestService;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.entity.VerificationRequest;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class VerificationRequestImpls implements VerificationRequestervice {

    @Autowired
    private VerificationRequestRepository vrr;

    @Override
    public initiateVerification(VerificationRequest request){
        return vrr.save(request);
    }

    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord updated) {
        CredentialRecord existing = crr.findById(id).orElseThrow(() ->new RuntimeException("Credential not found"));

        existing.setCredentialCode(updated.getCredentialCode());
        existing.setHolderId(updated.getHolderId());
        existing.setStatus(updated.getStatus());

        return crr.save(existing);
    }

    @Override
    public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
        return crr.findByHolderId(holderId);
    }

    @Override
    public CredentialRecord getCredentialByCode(String code) {
        return crr.findByCredentialCode(code);
    }

    @Override
    public List<CredentialRecord> getAllCredentials() {
        return crr.findAll();
    }
}