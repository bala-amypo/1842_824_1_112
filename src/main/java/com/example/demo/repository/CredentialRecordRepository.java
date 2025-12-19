package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CredentialRecord;

@Repository
public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, Long>{
    List<CredentialRecord> findByHolderId(Long holderId);

    // For GET /code/{credentialCode}
    CredentialRecord findByCredentialCode(String credentialCode);
}
