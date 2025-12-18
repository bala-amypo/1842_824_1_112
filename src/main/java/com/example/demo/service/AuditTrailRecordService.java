package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AuditTrailRecord;
public interface AuditTrailRecordService {
    
    AuditTrailRecord logEvent(AuditTrailRecord record);
    Long getLogsByCredential(Long credentialId);
    List<AuditTrailRecord> getAllLogs();
}
