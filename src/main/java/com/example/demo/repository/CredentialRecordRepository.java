package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CredentialRecord;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, Long>{
    List<CredentialRecord> findByHolderId(Long holderId);
    CredentialRecord findByCredentialCode(String credentialCode);

    List<CredentialRecord> findExpiredBefore(LocalDate date);
    List<CredentialRecord> findByStatusUsingHql(String status);
    List<CredentialRecord> searchByIssuerAndType(String issuer, String credentialType);
}
