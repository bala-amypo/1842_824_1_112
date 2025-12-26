// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.CredentialRecord;

// public interface CredentialRecordService{
//     CredentialRecord createCredential(CredentialRecord record);
//     CredentialRecord updateCredential(Long id, CredentialRecord updated);
//     List<CredentialRecord> getCredentialsByHolder(Long holderId);
//     CredentialRecord getCredentialByCode(String code);
//     List<CredentialRecord> getAllCredentials();
// }

package com.example.demo.service;

import com.example.demo.entity.CredentialRecord;
import java.time.LocalDate;
import java.util.List;

public interface CredentialRecordService {
    CredentialRecord createCredential(CredentialRecord record);
    CredentialRecord updateCredential(Long id, CredentialRecord updated);
    List<CredentialRecord> getAllCredentials();
    List<CredentialRecord> getCredentialsByHolder(Long holderId);
    CredentialRecord getCredentialByCode(String code);
    List<CredentialRecord> findExpiredBefore(LocalDate date);
    List<CredentialRecord> findByStatusUsingHql(String status);
    List<CredentialRecord> searchByIssuerAndType(String issuer, String type);
}
