package com.example.demo.service.impls;

import com.example.demo.service.CredentialRecordService;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.entity.CredentialRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CredentialRecordImpls implements CredentialRecordService {

    private final CredentialRecordRepository crr;

    // ✅ Constructor Injection
    public CredentialRecordImpls(CredentialRecordRepository crr) {
        this.crr = crr;
    }

    @Override
    public CredentialRecord createCredential(CredentialRecord record) {
        if (record.getStatus() == null) record.setStatus("VALID");
        return crr.save(record);
    }

    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord updated) {
        CredentialRecord existing = crr.findById(id)
            .orElseThrow(() -> new RuntimeException("Credential not found"));
        existing.setCredentialCode(updated.getCredentialCode());
        existing.setHolderId(updated.getHolderId());
        existing.setStatus(updated.getStatus());
        return crr.save(existing);
    }

    @Override
    public List<CredentialRecord> getAllCredentials() {
        return crr.findAll();
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
    public List<CredentialRecord> findExpiredBefore(LocalDate date) {
        return crr.findExpiredBefore(date);
    }

    @Override
    public List<CredentialRecord> findByStatusUsingHql(String status) {
        return crr.findByStatusUsingHql(status);
    }

    @Override
    public List<CredentialRecord> searchByIssuerAndType(String issuer, String type) {
        return crr.searchByIssuerAndType(issuer, type);
    }
}
