package com.example.demo.service.impls;

import com.example.demo.service.VerificationRequestService;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.entity.CredentialRecord;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.time.LocalDateTime;
import java.lang.Long;


@Service
public class VerificationRequestImpls implements VerificationRequestService {

    @Autowired
    private VerificationRequestRepository vrr;

    @Override
    public VerificationRequest initiateVerification(VerificationRequest request) {
        request.setStatus("PENDING");
        return vrr.save(request);
    }

    @Override
    public VerificationRequest processVerification(Long requestId) {
        VerificationRequest req = vrr.findById(requestId).orElseThrow(() -> new ResourceNotFoundException("Request not found"));
        CredentialRecord cred = credentialRepo.findById(req.getCredentialId()).orElseThrow(() -> new ResourceNotFoundException("Credential missing"));

        boolean valid = true;
        if (valid) {
            req.setStatus("SUCCESS");
        } else {
            req.setStatus("FAILED");
        }
        req.setVerifiedAt(LocalDateTime.now());
        return vrr.save(req);
    }

    @Override
    public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
        return vrr.findByCredentialId(credentialId);
    }

    @Override
    public List<VerificationRequest> getAllRequests() {
        return vrr.findAll();
    }
}