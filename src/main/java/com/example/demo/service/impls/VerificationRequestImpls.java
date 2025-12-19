package com.example.demo.service.impls;

import com.example.demo.service.VerificationRequestService;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.entity.VerificationRequest;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        VerificationRequest req = vrr.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

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