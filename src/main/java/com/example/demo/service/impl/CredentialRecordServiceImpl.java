package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CredentialRecordServiceImpl implements CredentialRecordService {
    private final CredentialRecordRepository credentialRepo;

    public CredentialRecordServiceImpl(CredentialRecordRepository credentialRepo) {
        this.credentialRepo = credentialRepo;
    }

    // ... (keep other methods: createCredential, updateCredential, etc.)

    @Override
    public List<CredentialRecord> getAllCredentials() {
        return credentialRepo.findAll();
    }
    
    @Override
    public CredentialRecord createCredential(CredentialRecord record) { return credentialRepo.save(record); }
    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord update) { return credentialRepo.save(update); }
    @Override
    public List<CredentialRecord> getCredentialsByHolder(Long holderId) { return credentialRepo.findByHolderId(holderId); }
    @Override
    public CredentialRecord getCredentialByCode(String code) { return credentialRepo.findByCredentialCode(code).orElse(null); }
}