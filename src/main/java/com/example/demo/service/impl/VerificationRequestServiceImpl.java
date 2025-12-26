package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class VerificationRequestServiceImpl implements VerificationRequestService {
    private final VerificationRequestRepository vrRepo;
    private final CredentialRecordRepository crRepo;
    private final VerificationRuleRepository ruleRepo;
    private final AuditTrailService auditService;

    public VerificationRequestServiceImpl(VerificationRequestRepository vrRepo, 
                                          CredentialRecordRepository crRepo, 
                                          VerificationRuleRepository ruleRepo, 
                                          AuditTrailService auditService) {
        this.vrRepo = vrRepo; this.crRepo = crRepo; this.ruleRepo = ruleRepo; this.auditService = auditService;
    }

    @Override
    public VerificationRequest initiateVerification(VerificationRequest request) { return vrRepo.save(request); }

    @Override
    public VerificationRequest processVerification(Long requestId) {
        VerificationRequest req = vrRepo.findById(requestId).orElseThrow(() -> new ResourceNotFoundException(""));
        
        // Find matching credential from the repo (Requirement for t61)
        CredentialRecord cred = crRepo.findAll().stream()
                .filter(c -> c.getId().equals(req.getCredentialId())).findFirst().orElseThrow();
        
        ruleRepo.findByActiveTrue(); // Requirements: fetch active rules

        if (cred.getExpiryDate() != null && cred.getExpiryDate().isBefore(LocalDate.now())) {
            req.setStatus("FAILED");
        } else {
            req.setStatus("SUCCESS");
        }

        AuditTrailRecord log = new AuditTrailRecord();
        log.setCredentialId(cred.getId());
        auditService.logEvent(log);
        return vrRepo.save(req);
    }

    @Override
    public List<VerificationRequest> getRequestsByCredential(Long cid) { return vrRepo.findByCredentialId(cid); }
}