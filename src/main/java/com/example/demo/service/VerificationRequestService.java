package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.VerificationRequest;

public interface VerificationRequestService {
    VerificationRequest logEvent(VerificationRequest req uest );
    List<VerificationRequest> getRequestsByCredential(Long credentialId);
    List<VerificationRequest> getAllLogs();
}
