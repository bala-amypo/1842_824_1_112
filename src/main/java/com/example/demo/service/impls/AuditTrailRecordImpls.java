package com.example.demo.service.impls;

import com.example.demo.service.AuditTrailRecordService;
import com.example.demo.repository.AuditTrailRecordRepository;
import org.springframework.stereotype.service;

@Service

public class AuditTrailRecordImpls implements AuditTrailRecordService{
    private final AuditTrailRecordRepository auditRepo;

    public AuditTrailRecordImpls(AuditTrailRecordRepository auditRepo){
        this.auditRepo=auditRepo;
    }

    @Override
    public void logEvent(AuditTrailRecord record){
        auditRepo.save(record);
    }

    @Override
    public List<AuditTrailRecord> getLogsByCredential(Long credentialId){
        return auditRepo.findByCredentialId(credentialId);
    }

    @Override
    public List<AuditTrailRecord> getAllLogs(){
        return auditRepo.findAll();
    }
}