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
        auditRepo
    }
}