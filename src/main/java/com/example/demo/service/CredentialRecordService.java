package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialRecord;

public interface CredentialRecordService{
    createCredential(CredentialRecord record);
    updateCredential(Long id, CredentialRecord updated);
    getCredentialsByHolder(Long holderId);
    getCredentialByCode(String code);
    getAllCredentials();
}