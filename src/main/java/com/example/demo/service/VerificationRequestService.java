package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VerificationRequest;

public interface VerificationRequestService {
    VerificationRequest initiateVerification(VerificationRequest request );
    VerificationRequest processVerification(Long requestID);
    List<VerificationRequest> getRequestsByCredential(Long credentialId);
    List<VerificationRequest> getAllRequests();
}