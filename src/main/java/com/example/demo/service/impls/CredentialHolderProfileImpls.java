package com.example.demo.service.impls;

import com.example.demo.service.CredentialHolderProfileService;
import com.example.demo.repository.CredentialHolderProfileRepository;
import com.example.demo.entity.CredentialHolderProfile;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CredentialHolderProfileImpls implements CredentialHolderProfileService {

    @Autowired
    private CredentialHolderProfileRepository chpr;

    @Override
    public CredentialHolderProfile createHolder(
            CredentialHolderProfile profile) {
        return chpr.save(profile);
    }

    @Override
    public CredentialHolderProfile getHolderById(Long id) {
        return chpr.findById(id).orElseThrow(() ->new RuntimeException("Holder not found"));
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

        CredentialHolderProfile holder = chpr.findById(id).orElseThrow(() -> new RuntimeException("Holder not found"));

        holder.setActive(active);
        return chpr.save(holder);
    }
}
