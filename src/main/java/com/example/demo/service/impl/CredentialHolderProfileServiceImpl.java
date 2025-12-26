package com.example.demo.service.impl;

import com.example.demo.entity.CredentialHolderProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CredentialHolderProfileRepository;
import com.example.demo.service.CredentialHolderProfileService;
import org.springframework.stereotype.Service;

@Service
public class CredentialHolderProfileServiceImpl implements CredentialHolderProfileService {
    private final CredentialHolderProfileRepository holderRepo;

    public CredentialHolderProfileServiceImpl(CredentialHolderProfileRepository holderRepo) {
        this.holderRepo = holderRepo;
    }

    @Override
    public CredentialHolderProfile createHolder(CredentialHolderProfile profile) {
        // PDF Rules: createHolder must call holderRepo.save and return it
        return holderRepo.save(profile);
    }

    @Override
    public CredentialHolderProfile getHolderById(Long id) {
        // PDF Rules: must call findById and throw ResourceNotFoundException if not found
        return holderRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Holder not found with id: " + id));
    }

    @Override
    public CredentialHolderProfile updateStatus(Long id, boolean active) {
        // PDF Rules: load existing, update active, save and return
        CredentialHolderProfile existing = getHolderById(id);
        existing.setActive(active);
        return holderRepo.save(existing);
    }
}