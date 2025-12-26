// package com.example.demo.service.impls;

// import com.example.demo.service.CredentialRecordService;
// import com.example.demo.repository.CredentialRecordRepository;
// import com.example.demo.entity.CredentialRecord;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// public class CredentialRecordServiceImpl implements CredentialRecordService {

//     private final CredentialRecordRepository crr;

//     public CredentialRecordImpls(CredentialRecordRepository crr) {
//         this.crr = crr;
//     }

//     @Override
//     public CredentialRecord createCredential(CredentialRecord record) {
//         if (record.getStatus() == null) record.setStatus("VALID");
//         return crr.save(record);
//     }

//     @Override
//     public CredentialRecord updateCredential(Long id, CredentialRecord updated) {
//         CredentialRecord existing = crr.findById(id).orElseThrow(() -> new RuntimeException("Credential not found with ID: " + id));

//         existing.setCredentialCode(updated.getCredentialCode());
//         existing.setHolderId(updated.getHolderId());
//         existing.setStatus(updated.getStatus());
//         existing.setIssueDate(updated.getIssueDate());
//         existing.setExpiryDate(updated.getExpiryDate());

//         return crr.save(existing);
//     }

//     @Override
//     public List<CredentialRecord> getAllCredentials() {
//         return crr.findAll();
//     }

//     @Override
//     public CredentialRecord getCredentialById(Long id) {
//         return crr.findById(id).orElseThrow(() -> new RuntimeException("Credential not found"));
//     }

//     @Override
//     public List<CredentialRecord> getCredentialsByHolder(Long holderId) {
//         return crr.findByHolderId(holderId);
//     }

//     @Override
//     public CredentialRecord getCredentialByCode(String code) {
//         return crr.findByCredentialCode(code);
//     }

//     @Override
//     public List<CredentialRecord> findByExpiryDateBefore(LocalDateTime date) {
//         return crr.findByExpiryDateBefore(date);
//     }

//     @Override
//     public List<CredentialRecord> findByStatusUsingHql(String status) {
//         return crr.findByStatusUsingHql(status);
//     }

//     @Override
//     public List<CredentialRecord> searchByIssuerAndType(String issuer, String type) {
//         return crr.searchByIssuerAndType(issuer, type);
//     }

//     @Override
//     public String deleteCredential(Long id) {
//         crr.deleteById(id);
//         return "Deleted successfully: " + id;
//     }
// }


package com.example.demo.service.impl;
import com.example.demo.entity.CredentialRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CredentialRecordRepository;
import com.example.demo.service.CredentialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service @RequiredArgsConstructor
public class CredentialRecordServiceImpl implements CredentialRecordService {
    private final CredentialRecordRepository credentialRepo;

    @Override
    public CredentialRecord createCredential(CredentialRecord record) {
        if (record.getExpiryDate() != null && record.getExpiryDate().isBefore(LocalDate.now())) {
            record.setStatus("EXPIRED");
        } else if (record.getStatus() == null) {
            record.setStatus("VALID");
        }
        return credentialRepo.save(record);
    }

    @Override
    public CredentialRecord updateCredential(Long id, CredentialRecord update) {
        CredentialRecord existing = credentialRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        existing.setCredentialCode(update.getCredentialCode());
        return credentialRepo.save(existing);
    }

    @Override public List<CredentialRecord> getCredentialsByHolder(Long id) { return credentialRepo.findByHolderId(id); }
    @Override public CredentialRecord getCredentialByCode(String code) { return credentialRepo.findByCredentialCode(code).orElse(null); }
}