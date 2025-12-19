package com.example.demo.service.impls;

import com.example.demo.service.Service;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.entity.CredentialRecord;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CredentialRecordImpls implements CredentialRecordService {

    @Autowired
    private CredentialRecordRepository crr;

    @Override
    public CredentialRecord createHolder(CredentialRecord record) {
        return crr.save(record);
    }

    @Override
    public CredentialRecord getHolderById(Long id, CredentialRecord) {
        return crr.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Holder not found"));
    }

    @Override
    public List<CredentialHolderProfile> getAllHolders() {
        return chpr.findAll();
    }

    @Override
    public CredentialHolderProfile findByHolderId(String holderId) {
        return chpr.findByHolderId(holderId);
    }

    @Override
    public CredentialHolderProfile updateHolderStatus(
            Long id, boolean active) {

        CredentialHolderProfile holder = chpr.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Holder not found"));

        holder.setActive(active);
        return chpr.save(holder);
    }
}
