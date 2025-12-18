package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialHolderProfile;

public interface CredentialHolderProfileService {
    CredentialHolderProfile createHolder(CredentialHolderProfile profile);
    List<CredentialHolderProfile> getHolderById(Long id);
    List<CredentialHolderProfile> getAllHolders();
    List<CredentialHolderProfile> findByHolderId(String holderId);
    List<CredentialHolderProfile> updateHolderStatus(Long id, boolean active);
}