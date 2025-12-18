package com.example.demo.service;

import java.util.List;

public interface AuditTrailRecordService {
    
    void logEvent( AuditTrailRecord record);
    List<AuditTrailRecord> getLogsByCredential(Long credentialId);
    List<AuditTrailRecord> getAllLogs();
}