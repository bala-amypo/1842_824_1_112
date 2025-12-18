package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.AuditTrailRecord;

public interface CredentialHolderProfile {
    CredentialHolderProfile createHolder(CredentialHolderProfile profile);
    getHolderById(Long id);
}