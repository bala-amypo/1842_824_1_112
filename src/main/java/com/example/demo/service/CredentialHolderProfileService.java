package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AuditTrailRecord;

public interface CredentialHolderProfile {
    CredentialHolderProfile createHolder(CredentialHolderProfile profile);
    List<AuditTrailRecord> getHolderById(Long id);
    List<AuditTrailRecord> getAllHolders();
    findByHolderId(String holderId);
}