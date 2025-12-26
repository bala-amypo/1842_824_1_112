package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.util.List;

public interface CredentialRecordService {
    CredentialRecord createCredential(CredentialRecord credentialRecord);
    List<CredentialRecord> getAllCredentials();
    CredentialRecord getCredentialById(Long id);
    List<CredentialRecord> getCredentialsByHolder(Long holderId);  
    CredentialRecord getCredentialByCode(String credentialCode);   
    CredentialRecord updateCredential(Long id, CredentialRecord updatedData);
    String deleteCredential(Long id);
}
