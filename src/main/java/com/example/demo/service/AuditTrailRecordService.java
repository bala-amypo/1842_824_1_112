package com.example.collectiondb.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.collectiondb.entity.AuditTrailRecord;

@Service
public interface AuditTrailRecord {
    
    public logEvent(AuditTrailRecord record);

    public getLogsByCredential(Long credentialId);

    public getAllLogs();
}
