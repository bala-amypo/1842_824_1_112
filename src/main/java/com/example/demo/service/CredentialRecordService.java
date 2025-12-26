// package com.example.demo.service;

// import com.example.demo.entity.CredentialRecord;
// import java.time.LocalDateTime;
// import java.util.List;

// public interface CredentialRecordService {
//     CredentialRecord createCredential(CredentialRecord credentialRecord);
//     CredentialRecord updateCredential(Long id, CredentialRecord updatedData);
//     List<CredentialRecord> getAllCredentials();
    
//     CredentialRecord getCredentialById(Long id);
//     List<CredentialRecord> getCredentialsByHolder(Long holderId);
//     CredentialRecord getCredentialByCode(String credentialCode);

//     // NEWLY ADDED - must exist because implementation has it
//     List<CredentialRecord> findByExpiryDateBefore(LocalDateTime date);
//     List<CredentialRecord> findByStatusUsingHql(String status);
//     List<CredentialRecord> searchByIssuerAndType(String issuer, String type);

//     // REQUIRED - missing before
//     String deleteCredential(Long id);
// }


package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.CredentialRecord;

public interface CredentialRecordService {
    List<CredentialRecord> getAllCredentials();
}
