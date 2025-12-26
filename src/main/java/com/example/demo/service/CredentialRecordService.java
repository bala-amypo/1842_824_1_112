package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {
    CredentialRecord createCredential(CredentialRecord record);
    CredentialRecord updateCredential(Long id, CredentialRecord update);
    List<CredentialRecord> getCredentialsByHolder(Long holderId);
    CredentialRecord getCredentialByCode(String code);
    // Add this to support the logic required by tests t61 and t62
    List<CredentialRecord> getAllCredentials();
}