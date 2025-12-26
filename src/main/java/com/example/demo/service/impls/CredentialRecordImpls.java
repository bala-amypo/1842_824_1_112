package com.example.demo.service.impl;

import com.example.demo.entity.CredentialRecord;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialRecordImpls implements CredentialRecordService {

    @Autowired
    private CredentialRecordRepository credentialRecordRepository;

    // CREATE
    @Override
    public CredentialRecord createCredential(CredentialRecord credentialRecord) {
        if (credentialRecord.getHolderId() == null || credentialRecord.getCredentialCode() == null) {
            throw new BadRequestException("HolderId & CredentialCode cannot be null");
        }
        return credentialRecordRepository.save(credentialRecord);
    }

    // GET ALL
    @Override
    public List<CredentialRecord> getAllCredentials() {
        return credentialRecordRepository.findAll();
    }

    // GET BY ID
    @Override
    public CredentialRecord getCredentialById(Long id) {
        return credentialRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Credential not found with Id: " + id));
    }

    // UPDATE
    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord updatedData) {
        CredentialRecord existing = credentialRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot update, no record found with Id: " + id));

        existing.setCredentialCode(updatedData.getCredentialCode());
        existing.setTitle(updatedData.getTitle());
        existing.setIssuedDate(updatedData.getIssuedDate());
        existing.setExpiryDate(updatedData.getExpiryDate());
        existing.setStatus(updatedData.getStatus());

        return credentialRecordRepository.save(existing);
    }

    // DELETE
    @Override
    public String deleteCredential(Long id) {
        CredentialRecord record = credentialRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No record found to delete with Id: " + id));

        credentialRecordRepository.delete(record);
        return "Credential deleted successfully with Id: " + id;
    }
}
