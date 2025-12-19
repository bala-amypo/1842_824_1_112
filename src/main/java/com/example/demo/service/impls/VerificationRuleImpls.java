package com.example.demo.service.impls;

import com.example.demo.service.VerificationRuleService;
import com.example.demo.repository.VerificationRuleRepository;
import com.example.demo.entity.VerificationRule;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CredentialRecordImpls implements CredentialRecordService {

    @Autowired
    private CredentialRecordRepository crr;

    @Override
    public CredentialRecord createCredential(CredentialRecord record) {
        if (record.getStatus() == null) {
            record.setStatus("VALID");
        }
        return crr.save(record);
    }

    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord updated) {
        CredentialRecord existing = crr.findById(id).orElseThrow(() ->new RuntimeException("Credential not found"));

        existing.setCredentialCode(updated.getCredentialCode());
        existing.setHolderId(updated.getHolderId());
        existing.setStatus(updated.getStatus());

        return crr.save(existing);
    }

    @Override
    public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
        return crr.findByHolderId(holderId);
    }

    @Override
    public CredentialRecord getCredentialByCode(String code) {
        return crr.findByCredentialCode(code);
    }

    @Override
    public List<CredentialRecord> getAllCredentials() {
        return crr.findAll();
    }
}
