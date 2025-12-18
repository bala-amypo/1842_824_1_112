package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AuditTrailRecord;
public interface AuditTrailRecordService {
    
    void logEvent(AuditTrailRecord record);
    int C(Long credentialId);
    List<AuditTrailRecord> getAllLogs();
}
























