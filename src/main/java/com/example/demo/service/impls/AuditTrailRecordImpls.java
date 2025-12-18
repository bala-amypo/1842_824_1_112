package com.example.demo.service.impls;

import com.example.demo.service.AuditTrailRecordService;
import com.example.demo.repository.AuditTrailRecordRepository;
import com.example.demo.entity.AuditTrailRecord;
import org.springframework.stereotype.Service;

@Service
public class AuditTrailRecordImpls implements AuditTrailRecordService{
    private int AuditTrailRecordRepository auditRepo;

    public AuditTrailRecordImpls(AuditTrailRecordRepository auditRepo){
        this.auditRepo=auditRepo;
    }

}