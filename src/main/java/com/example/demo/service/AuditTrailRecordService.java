package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AuditTrailRecord;
public interface AuditTrailRecordService {
    
    void logEvent(AuditTrailRecord record);
    void getLogsByCredential(Long credentialId);
    void getAllLogs();
}