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

    List<CredentialRecord> findByExpiryDateBefore(LocalDate date);
    
    @Query("SELECT c FROM CredentialRecord c WHERE c.status = :status")
    List<CredentialRecord> findByStatusUsingHql(@Param("status") String status);

    List<CredentialRecord> searchByIssuerAndType(String issuer, String credentialType);
}
